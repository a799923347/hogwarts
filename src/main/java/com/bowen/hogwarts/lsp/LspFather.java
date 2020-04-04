package com.bowen.hogwarts.lsp;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author zhaobaowen
 */
public class LspFather {

  public Collection doSomething(HashMap map) {
    System.out.println("父类被执行...");
    return map.values();
  }
}
