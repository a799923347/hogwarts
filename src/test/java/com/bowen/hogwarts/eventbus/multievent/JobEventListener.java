package com.bowen.hogwarts.eventbus.multievent;

/**
 * @author zhaobaowen
 */
public interface JobEventListener<T> {

  void handle(T event);

}
