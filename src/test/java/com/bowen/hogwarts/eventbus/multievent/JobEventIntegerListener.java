package com.bowen.hogwarts.eventbus.multievent;

import com.google.common.eventbus.Subscribe;

/**
 * @author zhaobaowen
 */
public class JobEventIntegerListener implements JobEventListener<JobEventInteger> {

  @Override
  @Subscribe
  public void handle(JobEventInteger event) {
    Integer source = event.getSource();
    System.out.println("Integer message: " + source);
  }
}
