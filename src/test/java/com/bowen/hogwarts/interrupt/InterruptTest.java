package com.bowen.hogwarts.interrupt;

import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class InterruptTest {

  @Test
  public void test() throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(1000 * 30);
      } catch (InterruptedException e) {
        System.out.println("响应中断");
        e.printStackTrace();
      }
    });
    thread.start();
    thread.interrupt();
    System.out.println("等待线程响应中断");
    Thread.sleep(1000 * 40);
  }

}

