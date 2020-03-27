package com.bowen.hogwarts.eventbus.multievent;

/**
 * @author zhaobaowen
 */
public class JobEventString extends JobEvent<String> {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public JobEventString(String source) {
    super(source);
  }

  @Override
  public String getSource() {
    return super.getSource();
  }
}
