package com.bowen.hogwarts.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Slf4j
@Component
public class SpringBootSchedulerSample {

  @Scheduled(cron = "0/2 * * * * *")
  public void schedule1() {
    String taskName = "task1";
    log.info("定时任务{}执行,thread={}", taskName, Thread.currentThread());
  }

  @Scheduled(cron = "0/1 * * * * *")
  public void schedule2() {
    String taskName = "hahahahahahahahahah";
    log.info("定时任务{}执行,thread={}", taskName, Thread.currentThread());
  }

  // @Scheduled(cron = "0 0/1 * * * *")
  public void scheduleGc() {
    String taskName = "gcTrigger";
    log.info("定时任务{}执行,thread={}", taskName, Thread.currentThread());
    System.gc();
  }
}
