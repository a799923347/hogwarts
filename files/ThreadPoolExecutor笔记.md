```java
private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
```
ctl:32位整型，高3位用于维护线程池的状态，低29位用于维护worker的数量(即线程的数量)。

Worker继承了AQS，实现了Runnable接口，所以在exit的时候，使用AQS自有的Unsafe类+state状态的CAS来保证线程安全。所有的 Worker 保存在 HashSet<Worker> 中，Worker 的 run 方法（实际上调用的是 ThreadPoolExecutor 中的 runWorker 方法）中会循环从队列中获取任务，该功能的是通过 ThreadPoolExecutor 中的 getTask() 方法实现的，当队列返回 null 时， 在 ThreadPoolExecutor 的 processWorkerExit 方法中将 Worker 从 HashSet<Worker> 中移除（移除过程会加锁），也就是结束该线程，线程池的非核心线程的 keepAliveTime 的维护也是在 getTask 方法中完成的，当检测到线程数超过核心线程数<span style="border-bottom:2px dashed red;">或者</span>参数 allowCoreThreadTimeOut 为 true（即允许核心线程退出），关键代码 ```workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS)```。

#### execute()方法
线程池执行入口，最上层的控制逻辑，基本可描述为：线程小于核心线程数时，启动一个新线程去执行任务，达到核心线程数后，则将提交的任务添加到队列中，如果添加队列失败则再继续启用新线程执行提交的任务，若此时线程已经达到限制的最大线程数，则按照初始化线程池时声明的策略reject任务。

```java
public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    /*
     * Proceed in 3 steps:
     *
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     *
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     *
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
     */
    int c = ctl.get();
    // workerCountOf获取ctl低29位的值，即worker的数量
    if (workerCountOf(c) < corePoolSize) {
        // Runnable添加worker集合成功则直接return
        if (addWorker(command, true))
            return;
        // 重新获取ctl的值
        c = ctl.get();
    }
    // 运行至此处则说明addWorker未成功，有几种可能：
    // 1 
    // 2
    if (isRunning(c) && workQueue.offer(command)) {
        /*
         * 运行至此处说明线程池处于运行状态且Runnable成功被添加到队列中
         */
        int recheck = ctl.get();
        // 重新获取ctl的运行状态，如果非running状态则将Runnable从队列中移除，移除成功则执行预定义的reject的策略
        if (! isRunning(recheck) && remove(command))
            reject(command);
        // 线程池处于running状态 or 非running状态但从队列移除Runnable失败
        // 如果woker的数量为0，则添加一个null worker
        else if (workerCountOf(recheck) == 0)
            addWorker(null, false);
    }
    else if (!addWorker(command, false))
        reject(command);
}
```
#### addWorker方法
```java
private boolean addWorker(Runnable firstTask, boolean core) {
    retry:
    for (;;) {
        int c = ctl.get();
        int rs = runStateOf(c);

        // Check if queue empty only if necessary.
        if (rs >= SHUTDOWN &&
            ! (rs == SHUTDOWN &&
               firstTask == null &&
               ! workQueue.isEmpty()))
            return false;

        for (;;) {
            // 获取worker的数量
            int wc = workerCountOf(c);
            // 1 如果worker的数量超出CAPACITY则直接返回false
            // 2 在worker未超出CAPACITY的情况下，
            //   2.1 如果指明使用核心线程且worker超出了核心线程的数量，则返回false
            //   2.2 如果未指明使用核心线程且worker超出了最大线程数，则返回false
            //   否则代码继续往下走
            if (wc >= CAPACITY ||
                wc >= (core ? corePoolSize : maximumPoolSize))
                return false;
            // 通过cas操作增加worker的数量，如果成功则跳出break代码块
            if (compareAndIncrementWorkerCount(c))
                break retry;
            // 运行到这里说明cas操作失败，重新获取control的值
            c = ctl.get();  // Re-read ctl
            // 如果线程池的运行状态因为上述操作发生了变化，则重新执行break代码块
            // 如果线程是的状态没有变化则重试for循环
            if (runStateOf(c) != rs)
                continue retry;
            // else CAS failed due to workerCount change; retry inner loop
        }
    }
    // 代码运行到这里说明cas增加worker数量的操作成功了
    boolean workerStarted = false;
    boolean workerAdded = false;
    Worker w = null;
    try {
        // Worker封装线程执行逻辑，两个主要成员变量：Thread和Runnable，Runnable的值来自外部传递进来的Runnable，
        // Thread一般由ThreadFactory新建
        w = new Worker(firstTask);
        final Thread t = w.thread;
        if (t != null) {
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try {
                // Recheck while holding lock.
                // Back out on ThreadFactory failure or if
                // shut down before lock acquired.
                int rs = runStateOf(ctl.get());

                if (rs < SHUTDOWN ||
                    (rs == SHUTDOWN && firstTask == null)) {
                    if (t.isAlive()) // precheck that t is startable
                        throw new IllegalThreadStateException();
                    workers.add(w);
                    int s = workers.size();
                    if (s > largestPoolSize)
                        largestPoolSize = s;
                    workerAdded = true;
                }
            } finally {
                mainLock.unlock();
            }
            // worker添加成功，则启动线程，运行Worker对象中的runWorker(Worker w)方法
            if (workerAdded) {
                t.start();
                workerStarted = true;
            }
        }
    } finally {
        if (! workerStarted)
            addWorkerFailed(w);
    }
    return workerStarted;
}
```

```java
final void runWorker(Worker w) {
        Thread wt = Thread.currentThread();
        Runnable task = w.firstTask;
        w.firstTask = null;
        w.unlock(); // allow interrupts
        boolean completedAbruptly = true;
        try {
            while (task != null || (task = getTask()) != null) {
                w.lock();
                // If pool is stopping, ensure thread is interrupted;
                // if not, ensure thread is not interrupted.  This
                // requires a recheck in second case to deal with
                // shutdownNow race while clearing interrupt
                if ((runStateAtLeast(ctl.get(), STOP) ||
                     (Thread.interrupted() &&
                      runStateAtLeast(ctl.get(), STOP))) &&
                    !wt.isInterrupted())
                    wt.interrupt();
                try {
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        task.run();
                    } catch (RuntimeException x) {
                        thrown = x; throw x;
                    } catch (Error x) {
                        thrown = x; throw x;
                    } catch (Throwable x) {
                        thrown = x; throw new Error(x);
                    } finally {
                        afterExecute(task, thrown);
                    }
                } finally {
                    task = null;
                    w.completedTasks++;
                    w.unlock();
                }
            }
            completedAbruptly = false;
        } finally {
            processWorkerExit(w, completedAbruptly);
        }
}
```

```java
private Runnable getTask() {
        boolean timedOut = false; // Did the last poll() time out?

        for (;;) {
            int c = ctl.get();
            int rs = runStateOf(c);

            // Check if queue empty only if necessary.
            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
                decrementWorkerCount();
                return null;
            }

            int wc = workerCountOf(c);

            // Are workers subject to culling?
            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;

            if ((wc > maximumPoolSize || (timed && timedOut))
                && (wc > 1 || workQueue.isEmpty())) {
                if (compareAndDecrementWorkerCount(c))
                    return null;
                continue;
            }

            try {
                Runnable r = timed ?
                    workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                    workQueue.take();
                if (r != null)
                    return r;
                timedOut = true;
            } catch (InterruptedException retry) {
                timedOut = false;
            }
        }
}
```

```java
private void processWorkerExit(Worker w, boolean completedAbruptly) {
        if (completedAbruptly) // If abrupt, then workerCount wasn't adjusted
            decrementWorkerCount();

        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
        } finally {
            mainLock.unlock();
        }

        tryTerminate();

        int c = ctl.get();
        if (runStateLessThan(c, STOP)) {
            if (!completedAbruptly) {
                int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
                if (min == 0 && ! workQueue.isEmpty())
                    min = 1;
                if (workerCountOf(c) >= min)
                    return; // replacement not needed
            }
            addWorker(null, false);
        }
}
```

```java
final void tryTerminate() {
        for (;;) {
            int c = ctl.get();
            if (isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()))
                return;
            if (workerCountOf(c) != 0) { // Eligible to terminate
                interruptIdleWorkers(ONLY_ONE);
                return;
            }

            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try {
                if (ctl.compareAndSet(c, ctlOf(TIDYING, 0))) {
                    try {
                        terminated();
                    } finally {
                        ctl.set(ctlOf(TERMINATED, 0));
                        termination.signalAll();
                    }
                    return;
                }
            } finally {
                mainLock.unlock();
            }
            // else retry on failed CAS
        }
}
```