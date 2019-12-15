package com.bowen.hogwarts.lock;

/**
 * @author zhaobaowen
 */
public class LockTest {

  private volatile int myInt = 0;

  public synchronized void test() {
    myInt++;
    System.out.println(myInt);
  }

  public void test2() {
    synchronized (this) {
      myInt++;
      System.out.println(myInt);
    }
  }

}
