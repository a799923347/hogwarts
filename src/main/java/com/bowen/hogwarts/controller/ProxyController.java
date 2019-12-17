package com.bowen.hogwarts.controller;

import com.bowen.hogwarts.proxy.Subject;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaobaowen
 */
@Slf4j
@RestController
@RequestMapping("/proxy")
public class ProxyController {

  @Resource
  private Subject subject;

  @GetMapping("/test")
  public String testProxy() {
    String sayHello = subject.sayHello("小明");
    log.info("Subject对象类型:{}", subject.getClass());
    return sayHello + " " + LocalDateTime.now();
  }
}
