package com.bowen.hogwarts.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Slf4j
@Component
public class SampleTimer {

  @Scheduled(cron = "0/2 * * * * *")
  public void schedule1() {
    log.info("定时任务执行,thread={}", Thread.currentThread());
  }

}
