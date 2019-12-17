package com.bowen.hogwarts.proxy;

import org.springframework.stereotype.Service;

/**
 * @author zhaobaowen
 */
@Service
public class SubjectImpl implements Subject {

  @Override
  public String sayHello(String name) {
    return "hello, " + name;
  }

  @Override
  public String sayGoodBye() {
    return "good bye";
  }
}
