package com.bowen.hogwarts.controller;

import com.bowen.hogwarts.sentinel.ApiFlowCtrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaobaowen
 */
@RestController
@RequestMapping("/flow/control")
@Slf4j
public class FlowControlController {

  @ApiFlowCtrl(prefix = "流控测试")
  @GetMapping("/test")
  public ApiResponse<?> testFlowControl() {
    log.info("api请求");
    return ApiResponse.ok();
  }

}
