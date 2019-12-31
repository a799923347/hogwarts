package com.bowen.hogwarts.pecs;

import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class PecsFirstTest {

  @Test
  public void testExtends() {
    Example<? extends A> testAA = new Example<A>();
    // Example<? extends A> testAB = new Example<B>();//报错
    // Example<? extends A> testAC = new Example<C>();//报错
    Example<? extends B> testBA = new Example<A>();
    // Example<? extends B> testBC = new Example<C>();//报错
    Example<? extends C> testCA = new Example<A>();
    Example<? extends C> testCB = new Example<B>();

  }

  @Test
  public void testSuper() {
    Example<? super A> testAA = new Example<A>();
    Example<? super A> testAB = new Example<B>();
    Example<? super A> testAC = new Example<C>();
    // Example<? super B> testBA = new Example<A>();//报错
    Example<? super B> testBC = new Example<C>();
    // Example<? super C> testCA = new Example<A>();//报错
    // Example<? super C> testCB = new Example<B>();//报错
  }

  static class Example<T> {

  }

  /**
   * C
   * ↑
   * B
   * ↑
   * A
   */
  static class A extends B {

  }

  static class B extends C {

  }

  static class C {

  }

}
