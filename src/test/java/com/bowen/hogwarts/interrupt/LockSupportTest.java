package com.bowen.hogwarts.interrupt;

import java.util.concurrent.locks.LockSupport;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class LockSupportTest {

  @Test
  public void test() throws InterruptedException {
    Thread myThread = new Thread(() -> {
      System.out.println("子线程 " + Thread.currentThread() + " 即将被挂起");
      LockSupport.park();
      System.out.println("字线程 " + Thread.currentThread() + " 被恢复了");
      System.out.println("子线程 " + Thread.currentThread() + " 中断状态: " + Thread.interrupted());
    });
    myThread.start();
    Thread.sleep(2000);
    myThread.interrupt();
    System.out.println("主线程将要唤醒子线程");
    LockSupport.unpark(myThread);
    System.out.println("主线程已触发子线程的唤醒");
    Thread.sleep(2000);
  }

}
