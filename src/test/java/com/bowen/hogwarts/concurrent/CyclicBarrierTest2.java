package com.bowen.hogwarts.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaobaowen
 */
class WriteTaskTwo implements Runnable {

  private static int count = 0;
  private final int id = count++;
  private CyclicBarrier barrier;
  private static Random random = new Random(47);

  public WriteTaskTwo(CyclicBarrier cyclicBarrier) {
    this.barrier = cyclicBarrier;
  }

  @Override
  public void run() {

    while (!Thread.interrupted()) {
      System.out.println(this + " 开始写入数据...");
      try {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));      //以睡眠来模拟写入数据操作
        System.out.println(this + " 写入数据完毕，等待其他线程写入完毕" + " " + Thread.currentThread());
        barrier.await();
        TimeUnit.MILLISECONDS.sleep(10);
      } catch (InterruptedException e) {
        System.out.println(this + "is interrupted!");
      } catch (BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
      System.out.println("所有任务写入完毕，继续处理其他任务... " + Thread.currentThread());
    }

  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "-" + id;
  }
}

class CyclicBarrierManager implements Runnable {

  private CyclicBarrier barrier;
  private ExecutorService exec;

  public CyclicBarrierManager(CyclicBarrier barrier, ExecutorService exec, int N) {
    this.barrier = barrier;
    this.exec = exec;
    for (int i = 0; i < N - 1; ++i) {
      exec.execute(new WriteTaskTwo(barrier));
    }
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      try {
        barrier.await();
      } catch (InterruptedException e) {
        System.out.println(getClass().getSimpleName() + " 被中断了！");
      } catch (BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class CyclicBarrierTest2 {

  public static void main(String[] args) {
    int N = 4;
    CyclicBarrier barrier = new CyclicBarrier(N);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new CyclicBarrierManager(barrier, exec, N));
    exec.shutdown();
  }
}
