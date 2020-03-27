package com.bowen.hogwarts.eventbus.common;

import com.google.common.eventbus.Subscribe;

/**
 * @author zhaobaowen
 */
public class DataObserver1 {

  /**
   * 只有通过@Subscribe注解的方法才会被注册进EventBus
   * 而且方法有且只能有1个参数
   *
   * @param msg
   */
  @Subscribe
  public void func(String msg) {
    System.out.println("String msg: " + msg);
  }

}
