package com.bowen.hogwarts.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhaobaowen
 */
public class LspSon extends LspFather {

  //放大输入参数类型￼
  @Override
  public Set doSomething(HashMap map) {
    System.out.println("子类被执行...");
    return map.entrySet();
  }
}
