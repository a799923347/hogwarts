package com.bowen.hogwarts;

import org.junit.jupiter.api.Test;

/**
 * @author zhaobaowen
 */
public class TryCatchTest {

  @Test
  public void test() {
    int i = new TryCatchTestHelper().someAction();
    System.out.println("return的i的值=" + i);
  }

}

class TryCatchTestHelper {

  public int someAction() {
    int i = 1;
    try {
      return i;
    } finally {
      i = i + 1;
      System.out.println("finally中i的值=" + i);
    }
  }
}
