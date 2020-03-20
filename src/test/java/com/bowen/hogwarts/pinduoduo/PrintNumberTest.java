package com.bowen.hogwarts.pinduoduo;

import java.util.concurrent.locks.LockSupport;
import org.junit.Test;

/**
 * 拼多多面试题，两个线程交替打印奇偶数
 * @author zhaobaowen
 */
public class PrintNumberTest {

  private volatile int signal = 1;
  Thread printOdd, printEven;

  @Test
  public void twistPrint() {
    printOdd = new Thread(() -> {
      int count = 1;
      while (true) {
        if (signal == 1) {
          System.out.println(count);
          count = count + 2;
          signal = 0;
          LockSupport.unpark(printEven);
        } else {
          LockSupport.park(printOdd);
        }
      }
    });
    printOdd.start();

    printEven = new Thread(() -> {
      int count = 2;
      while (true) {
        if (signal == 0) {
          System.out.println(count);
          count = count + 2;
          signal = 1;
          LockSupport.unpark(printOdd);
        } else {
          LockSupport.park(printEven);
        }
      }
    });
    printEven.start();
  }

}
