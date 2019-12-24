package com.bowen.hogwarts.reactive;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author zhaobaowen
 */
@Configuration
public class RouterConfig {

  @Resource
  private TimeHandler timeHandler;

  @Bean
  public RouterFunction<ServerResponse> timerRouter() {
    return route(GET("/time"), req -> timeHandler.getTime(req))
        // 这种方式相对于上一行更加简洁
        .andRoute(GET("/date"), timeHandler::getDate);
  }
}
