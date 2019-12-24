package com.bowen.hogwarts.reactive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bowen.hogwarts.controller.ApiResponse;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author zhaobaowen
 */
@RestController
@RequestMapping("/reactive")
public class ReactiveController {

  @GetMapping("/hello")
  public Mono<ApiResponse<?>> hello() {
    return Mono.just(ApiResponse.act(LocalDateTime.now(), time -> {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("ts", time);
      return ApiResponse.ok(jsonObject);
    }));
  }

}
