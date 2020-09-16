package com.bowen.hogwarts.set;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import java.util.Set;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class SetJsonTest {

  @Test
  public void test() {
    Set<String> sets = Sets.newHashSet();
    sets.add("hello");
    sets.add("world");
    System.out.println(JSON.toJSONString(sets));
  }

}
