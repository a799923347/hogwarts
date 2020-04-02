package com.bowen.hogwarts.loopdependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 实现 ApplicationContextAware 和 InitializingBean 接口
 * @author zhaobaowen
 */
@Component
public class CircularDependencyA3 implements ApplicationContextAware, InitializingBean {

  private CircularDependencyB3 circB3;

  private ApplicationContext context;

  public CircularDependencyB3 getCircB3() {
    return circB3;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    circB3 = context.getBean(CircularDependencyB3.class);
  }

  @Override
  public void setApplicationContext(final ApplicationContext ctx) throws BeansException {
    context = ctx;
  }
}
