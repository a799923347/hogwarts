package com.bowen.hogwarts.aop;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bowen.hogwarts.controller.ApiResponse;
import com.bowen.hogwarts.sentinel.ApiFlowCtrl;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author zhaobaowen
 */
@Aspect
@Component
@Slf4j
public class ApiAspect {

  @Pointcut("@annotation(com.bowen.hogwarts.sentinel.ApiFlowCtrl)")
  public void flowControlPointCut() {

  }

  @Around("flowControlPointCut()")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    String prefix = method.getAnnotation(ApiFlowCtrl.class).prefix();
    try(Entry entry = SphU.entry(prefix)) {
      return joinPoint.proceed();
    } catch (BlockException blockExp) {
      log.error("流量异常，by={}", blockExp.getRule(), blockExp);
      return ApiResponse.fail("流量超载");
    }
  }

}
