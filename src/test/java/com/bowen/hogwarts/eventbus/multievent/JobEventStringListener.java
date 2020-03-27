package com.bowen.hogwarts.eventbus.multievent;

import com.google.common.eventbus.Subscribe;

/**
 * @author zhaobaowen
 */
public class JobEventStringListener implements JobEventListener<JobEventString> {

  @Override
  @Subscribe
  public void handle(JobEventString event) {
    String source = event.getSource();
    System.out.println("String message: " + source);
  }
}
