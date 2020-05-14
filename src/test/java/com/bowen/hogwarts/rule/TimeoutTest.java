package com.bowen.hogwarts.rule;

import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author zhaobaowen
 */
public class TimeoutTest {

  @Rule
  public Timeout globalTimeout = Timeout.seconds(10);

  @Test
  public void givenLongRunningTest_whenTimout_thenTestFails() throws InterruptedException {
    TimeUnit.SECONDS.sleep(20);
  }
}
