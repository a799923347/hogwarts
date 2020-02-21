```java
private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
```
ctl:32位整型，高3位用于维护线程池的状态，低29位用于维护worker的数量(即线程的数量)。

Worker继承了AQS，实现了Runnable接口，所以在exit的时候，使用AQS自有的Unsafe类+state状态的CAS来保证线程安全。Worker的消亡通过调用```Thread.interrupt()```方法。运行中的worker会循环从队列中获取任务，当从队列中获取不到任务<span style="border-bottom:2px dashed red;">或者</span>封装在worker中的task为null时worker则会执行exit逻辑。