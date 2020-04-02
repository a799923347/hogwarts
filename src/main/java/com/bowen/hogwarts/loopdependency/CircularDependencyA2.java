package com.bowen.hogwarts.loopdependency;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * javax.annotation.PostConstruct注解解决循环依赖问题
 * @author zhaobaowen
 */
@Component
public class CircularDependencyA2 {

  @Autowired
  private CircularDependencyB2 circB2;

  @PostConstruct
  public void init() {
    circB2.setCircA2(this);
  }

  public CircularDependencyB2 getCircB2() {
    return circB2;
  }
}
