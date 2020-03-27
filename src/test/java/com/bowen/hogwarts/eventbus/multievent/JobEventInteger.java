package com.bowen.hogwarts.eventbus.multievent;

/**
 * @author zhaobaowen
 */
public class JobEventInteger extends JobEvent<Integer> {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public JobEventInteger(Integer source) {
    super(source);
  }

  @Override
  public Integer getSource() {
    return super.getSource();
  }
}
