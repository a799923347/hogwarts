package com.bowen.hogwarts.controller;

import com.bowen.hogwarts.proxy.Subject;
import com.bowen.hogwarts.proxy.SubjectTwo;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对比一个实现接口一个不实现接口在代理上是否有区别
 * @author zhaobaowen
 */
@Slf4j
@RestController
@RequestMapping("/proxy")
public class ProxyController {

  @Resource
  private Subject subject;
  @Resource
  private SubjectTwo subjectTwo;

  @GetMapping("/test")
  public String testProxy() {
    String sayHello = subject.sayHello("小明");
    log.info("Subject对象类型:{}", subject.getClass());
    return sayHello + " " + LocalDateTime.now();
  }

  @GetMapping("/test2")
  public String testProxy2() {
    String sayHello = subjectTwo.sayHello("小明");
    log.info("SubjectTwo对象类型:{}", subjectTwo.getClass());
    return sayHello + " " + LocalDateTime.now();
  }
}
