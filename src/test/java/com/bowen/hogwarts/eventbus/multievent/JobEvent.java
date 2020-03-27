package com.bowen.hogwarts.eventbus.multievent;

import java.util.EventObject;

/**
 * @author zhaobaowen
 */
public abstract class JobEvent<T> extends EventObject {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public JobEvent(T source) {
    super(source);
  }

  @Override
  public T getSource() {
    return (T) super.getSource();
  }
}
