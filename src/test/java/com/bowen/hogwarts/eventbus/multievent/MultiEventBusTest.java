package com.bowen.hogwarts.eventbus.multievent;

/**
 * @author zhaobaowen
 */
public class MultiEventBusTest {

  public static void main(String[] args) {

    JobEventIntegerListener integerListener = new JobEventIntegerListener();
    JobEventStringListener stringListener = new JobEventStringListener();
    // 注册事件监听器
    JobEventBusCenter.register(integerListener);
    JobEventBusCenter.register(stringListener);
    // 发送事件
    JobEventBusCenter.post(new JobEventString("hello eventBus"));
    JobEventBusCenter.post(new JobEventInteger(123));
  }

}
