package com.bowen.hogwarts.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Slf4j
@Component
public class SpringBootSchedulerSample {

  @Resource(name = "schedulerExecutorService")
  private ScheduledExecutorService schedulerExecutorService;

  // @Scheduled(cron = "0/2 * * * * *")
  public void schedule1() {
    String taskName = "task1";
    log.info("定时任务{}执行,thread={}", taskName, Thread.currentThread());
  }

  // @Scheduled(cron = "0/1 * * * * *")
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

  @PostConstruct
  public void generateHeapObject() {
    schedulerExecutorService.scheduleAtFixedRate(() -> {
      log.info("schedulerExecutorService定时任务");
      for (int i = 0; i < 1_000_000; i++) {
        new Object();
      }
    }, 0, 1, TimeUnit.SECONDS);
  }
}
