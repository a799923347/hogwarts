package com.bowen.hogwarts.singleton;

/**
 * @author zhaobaowen
 */
public class DoubleCheckLock {

  private volatile static Instance instance;

  public static Instance getInstance() {
    if (instance == null) {
      synchronized (DoubleCheckLock.class) {
        if (instance == null) {
          instance = new Instance();
        }
      }
    }
    return instance;
  }

  static class Instance {

  }

}
