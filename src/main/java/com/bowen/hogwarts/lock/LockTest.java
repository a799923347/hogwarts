package com.bowen.hogwarts.lock;

/**
 * @author zhaobaowen
 */
public class LockTest {

  private volatile int myInt = 0;

  public void test() {
    synchronized (this) {
      System.out.println(myInt);
    }
  }

  public void setMyInt(int i) {
    this.myInt = i;
  }

}
