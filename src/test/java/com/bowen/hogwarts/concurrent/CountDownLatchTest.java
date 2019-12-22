package com.bowen.hogwarts.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaobaowen
 */
class Task implements Runnable {

  private static int count = 0;
  private final int id = count++;
  final CountDownLatch latch;

  public Task(CountDownLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      System.out.println(this + "正在执行");
      TimeUnit.MILLISECONDS.sleep(3000);
      System.out.println(this + "执行完毕");
      latch.countDown();
    } catch (InterruptedException e) {
      System.out.println(this + " 被中断");
    }
  }

  @Override
  public String toString() {
    return "Task-" + id;
  }
}

public class CountDownLatchTest {

  public static void main(String[] args) {
    final CountDownLatch latch = new CountDownLatch(2);
    ExecutorService exec = Executors.newCachedThreadPool();

    exec.execute(new Task(latch));
    exec.execute(new Task(latch));

    try {
      System.out.println("等待2个子线程执行完毕...");
      long start = System.currentTimeMillis();
      latch.await();
      long end = System.currentTimeMillis();

      System.out.println("2个子线程已经执行完毕 " + (end - start));
      System.out.println("继续执行主线程");
    } catch (InterruptedException e) {
      System.out.println("主线程被中断");
    }
    exec.shutdown();
  }
}
