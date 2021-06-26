package com.bowen.hogwarts.lsp;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhaobaowen
 */
public class LspSon extends LspFather {

  //放大输入参数类型￼
//  @Override
//  public Set doSomething(HashMap map) {
//    System.out.println("子类被执行...");
//    return map.entrySet();
//  }

  public Collection doSomething(Map map) {
    System.out.println("子类重载方法...");
    return map.values();
  }

  public static void main(String[] args) {
    HashMap<Object, Object> map = Maps.newHashMap();
    map.put("a", "aaa");
    map.put("b", "bbb");
    LspSon lspSon = new LspSon();
    lspSon.doSomething(map);
  }
}
