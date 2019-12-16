package com.bowen.hogwarts.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaobaowen
 */
@Slf4j
public class SchedulerPoolSample {

  public void executeSomething() {
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("scheduler-pool-%d")
        .build();
    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, threadFactory);
    executorService.scheduleAtFixedRate(
        () -> log.info("scheduled thread pool task executing, thread={}", Thread.currentThread()),
        0, 3, TimeUnit.SECONDS);
  }

}
