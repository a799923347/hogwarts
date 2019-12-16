package com.bowen.hogwarts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhaobaowen
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("com.bowen.hogwarts")
@EnableScheduling
public class HogwartsApplication {

  public static void main(String[] args) {
    SpringApplication.run(HogwartsApplication.class, args);
  }

}
