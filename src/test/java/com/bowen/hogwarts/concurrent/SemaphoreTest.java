package com.bowen.hogwarts.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaobaowen
 */
class Worker implements Runnable {

  private static int count = 0;
  private final int id = count++;
  private int finished = 0;
  private Random random = new Random(47);
  private Semaphore semaphore;

  public Worker(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        semaphore.acquire();
        System.out.println(this + " 占用一个机器在生产...   ");
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        synchronized (this) {
          System.out.println(" 已经生产了" + (++finished) + "个产品," + "释放出机器");
        }
        semaphore.release();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "-" + id;
  }
}

public class SemaphoreTest {

  public static void main(String[] args) {
    int N = 8;            //工人数
    Semaphore semaphore = new Semaphore(5); //机器数目
    ExecutorService exec = Executors.newCachedThreadPool();
    for (int i = 0; i < N; ++i) {
      exec.execute(new Worker(semaphore));
    }
    exec.shutdown();
  }
}
