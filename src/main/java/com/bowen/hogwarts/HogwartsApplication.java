package com.bowen.hogwarts;

import java.util.Arrays;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhaobaowen
 */
@SpringBootApplication(scanBasePackages = "com.bowen.hogwarts")
@MapperScan("com.bowen.hogwarts.dao")
@EnableScheduling
public class HogwartsApplication {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(args));
    SpringApplication.run(HogwartsApplication.class, args);
  }

}
