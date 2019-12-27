package com.bowen.hogwarts.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author zhaobaowen
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

  @Bean
  public Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(200);
    executor.setThreadNamePrefix("BowenDeExecutor-");
    executor.initialize();
    return executor;
  }

  @Bean
  public ExecutorService executorService() {
    ThreadFactory threadFactory = new ThreadFactoryBuilder()
        .setNameFormat("bowen-common-in-shared-pool-%d")
        .build();
    ExecutorService executorService =
        new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2,
            5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(50), threadFactory,
            new ThreadPoolExecutor.AbortPolicy());
    return executorService;
  }

  @Bean
  public ScheduledExecutorService schedulerExecutorService() {
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("bowen-scheduler-pool-%d")
        .build();
    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, threadFactory);
    return executorService;

  }

}
