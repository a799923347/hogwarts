package com.bowen.hogwarts.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Aspect
@Component
@Slf4j
public class ProxyAop {

  @Pointcut("execution(* com.bowen.hogwarts.proxy..*(..))")
  public void pointcut() {
  }

  @Before("pointcut()")
  public void before() {
    log.info("before");
  }
}
