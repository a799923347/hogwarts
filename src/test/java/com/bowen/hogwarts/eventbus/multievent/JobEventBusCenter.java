package com.bowen.hogwarts.eventbus.multievent;

import com.google.common.eventbus.EventBus;

/**
 * @author zhaobaowen
 */
public class JobEventBusCenter {

  private static class JobEventBus {
    private static final EventBus EVENT_BUS = new EventBus();
  }

  public static void register(JobEventListener<?> listener) {
    JobEventBus.EVENT_BUS.register(listener);
  }

  public static void post(JobEvent<?> event) {
    JobEventBus.EVENT_BUS.post(event);
  }

}
