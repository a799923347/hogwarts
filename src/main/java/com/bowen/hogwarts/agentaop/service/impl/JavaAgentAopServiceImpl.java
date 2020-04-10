package com.bowen.hogwarts.agentaop.service.impl;

import com.bowen.hogwarts.agentaop.service.JavaAgentAopService;
import org.springframework.stereotype.Service;

/**
 * @author zhaobaowen
 */
@Service
public class JavaAgentAopServiceImpl implements JavaAgentAopService {

  @Override
  public String format(String name) {
    return "hello" + name;
  }
}
