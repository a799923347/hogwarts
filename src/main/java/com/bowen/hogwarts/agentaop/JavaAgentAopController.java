package com.bowen.hogwarts.agentaop;

import com.bowen.hogwarts.agentaop.service.JavaAgentAopService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试基于java agent实现的无侵入aop的controller
 * @author zhaobaowen
 */
@RestController
public class JavaAgentAopController {

  @Resource
  private JavaAgentAopService javaAgentAopService;

  @PostMapping("/hello/{name}")
  public String hello(@PathVariable String name) {
    return javaAgentAopService.format(name);
  }

}
