package com.bowen.hogwarts.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bowen.hogwarts.sentinel.ApiFlowCtrl;
import com.bowen.hogwarts.service.MyInterface;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Resource
  private List<MyInterface> interfaces;

  @ApiFlowCtrl(prefix = "流控测试")
  @GetMapping("/test")
  public ApiResponse<?> testFlowControl() {
    log.info("api请求");
    return ApiResponse.ok();
  }

  @SentinelResource(value = "annotation", blockHandler = "annotationControlBlockHandler")
  @GetMapping("/annotation")
  public ApiResponse<?> annotationControl() {
    log.info("注解实现流控的api");
    return ApiResponse.ok();
  }

  public ApiResponse<?> annotationControlBlockHandler(BlockException blockExp) {
    log.error("注解控制的api资源流量异常，by={}", blockExp.getRule(), blockExp);
    return ApiResponse.fail("注解管理的api资源流量异常");
  }

}
