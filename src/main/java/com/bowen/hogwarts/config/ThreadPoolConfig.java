package com.bowen.hogwarts.config;

import java.util.concurrent.Executor;
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

}
