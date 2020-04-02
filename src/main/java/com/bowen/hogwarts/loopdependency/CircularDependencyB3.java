package com.bowen.hogwarts.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Component
public class CircularDependencyB3 {

  private CircularDependencyA3 circA3;

  private String message = "Hi!";

  @Autowired
  public void setCircA3(CircularDependencyA3 circA3) {
    this.circA3 = circA3;
  }

  public String getMessage() {
    return message;
  }
}
