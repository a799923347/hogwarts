package com.bowen.hogwarts.loopdependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Component
public class CircularDependencyB2 {

  private CircularDependencyA2 circA2;

  private String message = "Hi!";

  public void setCircA2(CircularDependencyA2 circA2) {
    this.circA2 = circA2;
  }

  public String getMessage() {
    return message;
  }
}
