package com.bowen.hogwarts.proxy;

/**
 * @author zhaobaowen
 */
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
