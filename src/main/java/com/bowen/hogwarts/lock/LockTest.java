package com.bowen.hogwarts.lock;

/**
 * @author zhaobaowen
 */
public class LockTest {

  private volatile int myInt = 0;

  public synchronized void test() {
    System.out.println(myInt);
  }

  public void setMyInt(int i) {
    this.myInt = i;
  }

}
