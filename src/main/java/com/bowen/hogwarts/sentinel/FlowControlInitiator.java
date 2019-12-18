package com.bowen.hogwarts.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaobaowen
 */
@Configuration
@Slf4j
public class FlowControlInitiator implements ApplicationListener<ApplicationReadyEvent> {

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    List<FlowRule> flowRules = Lists.newArrayList();
    Collection<Object> beans = event.getApplicationContext()
        .getBeansWithAnnotation(RestController.class).values();
    for (Object value : beans) {
      Class<?> valueClass = value.getClass();
      if (AopUtils.isAopProxy(value)) {
        valueClass = AopUtils.getTargetClass(value);
      }
      Method[] declaredMethods = valueClass.getDeclaredMethods();
      for (Method declaredMethod : declaredMethods) {
        if (declaredMethod.isAnnotationPresent(ApiFlowCtrl.class)) {
          flowRules.add(defineFlowRule(declaredMethod));
        }
      }
    }
    FlowRuleManager.loadRules(flowRules);
    log.info("流控规则初始化完成，规则集={}", JSON.toJSONString(flowRules));
  }

  private FlowRule defineFlowRule(Method declaredMethod) {
    String prefix = declaredMethod.getAnnotation(ApiFlowCtrl.class).prefix();
    FlowRule rule = new FlowRule();
    rule.setResource(prefix);
    rule.setCount(10);
    rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
    rule.setLimitApp("default");
    return rule;
  }
}
