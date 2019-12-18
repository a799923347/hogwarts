package com.bowen.hogwarts.sentinel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.Order;

/**
 * @author zhaobaowen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Order(100)
public @interface ApiFlowCtrl {

  // 自动生成资源名时的前缀
  String prefix();
}

