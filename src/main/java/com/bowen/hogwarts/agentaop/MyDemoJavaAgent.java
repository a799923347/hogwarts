package com.bowen.hogwarts.agentaop;

import java.lang.instrument.Instrumentation;

/**
 * @author zhaobaowen
 */
public class MyDemoJavaAgent {

  public static void premain(String agentArgs, Instrumentation inst) {
    inst.addTransformer(new TheClassFileTransformer());
  }

}
