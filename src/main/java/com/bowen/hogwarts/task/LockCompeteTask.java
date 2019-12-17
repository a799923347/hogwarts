package com.bowen.hogwarts.task;

import com.bowen.hogwarts.lock.LockUtil;
import java.util.concurrent.Executor;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 用于竞争同一个synchronized方法，查看dump状态
 * @author zhaobaowen
 */
@Slf4j
@Component
public class LockCompeteTask {

  @Resource(name = "asyncExecutor")
  private Executor executor;

  // @Scheduled(cron = "0/1 * * * * *")
  public void compete() {
    for (int i = 0; i < 20; i++) {
      executor.execute(this::runnableWrapper);
    }
  }

  private void runnableWrapper() {
    try {
      LockUtil.test();
    } catch (Exception e) {
      log.error("lock compete exception occurred", e);
    }
  }

}
