package com.bowen.hogwarts.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaobaowen
 */
@Slf4j
public class TimerSample {

  public void timer() {

    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        log.info("timer task executing, thread={}", Thread.currentThread());
      }
    };
    Timer timer = new Timer();
    timer.schedule(timerTask, 0, 5000);

  }

}
