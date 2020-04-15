package com.bowen.hogwarts.singleton;

import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class ElvisTest {

  @Test
  public void test() {
    System.out.println("---");
    Elvis instance = Elvis.INSTANCE;
  }

}
