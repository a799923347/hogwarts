package com.bowen.hogwarts.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaobaowen
 */
@Service
@Slf4j
public class SubjectTwo {

  public String sayHello(String name) {
    return "SubjectTwo:hello, " + name;
  }
}
