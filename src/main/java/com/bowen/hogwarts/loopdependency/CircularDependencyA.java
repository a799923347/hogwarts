package com.bowen.hogwarts.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * org.springframework.context.annotation.Lazy注解解决循环依赖问题
 * @author zhaobaowen
 */
@Component
public class CircularDependencyA {

  private CircularDependencyB circB;

  @Autowired
  public CircularDependencyA(@Lazy CircularDependencyB circB) {
    this.circB = circB;
  }
}
