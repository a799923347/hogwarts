package com.bowen.hogwarts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhaobaowen
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class HogwartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsApplication.class, args);
	}

}
