package com.bowen.hogwarts.memory.layout;

import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class ObjectHeaderAndLockTest {

  final Object lock = new Object();

  @Test
  public void test() throws InterruptedException {
    new Thread(() -> {
      synchronized (lock) {
        System.out.println("子线程获取锁");
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          System.out.println("子线程中断");
        }
      }
    }).start();
    // 对象调用过hashCode()方法之后，就无法再进入偏向锁模式，而是直接膨胀为重量级锁
    System.out.println(lock.hashCode());
    synchronized (lock) {
      System.out.println("主线程正常获取锁");
      Thread.sleep(2000);
    }
  }

}
