package com.bowen.hogwarts.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Component
public class CircularDependencyB {

  private CircularDependencyA circA;

  @Autowired
  public CircularDependencyB(CircularDependencyA circA) {
    this.circA = circA;
  }
}
