package com.bowen.hogwarts.pecs;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * PECS：Producer Extends Consumer Super
 * @author zhaobaowen
 */
public class PecsTest {

  /**
   * superT中，因为存的都是类型T的父类（容器），所以如果去添加T类或者T的子类（操作），肯定没什么问题。但是如果将
   * 元素取出来，则不知道到底是什么类型，所以superT可以添加元素但是没法取出来
   */
  @Test
  public void testSuper() {
    List<? super T> superT = new ArrayList<>();
    superT.add(new T());
    superT.add(new Child1());
    superT.add(new Child2());
    superT.add(new Child3());
  }

  /**
   * extendsT中存放的其实是T的一种子类（现象），如果我们去添加元素，其实不知道到底应该添加T的哪个子类，这个时候，
   * 在进行强转的时候，肯定会出错。但是如果是从集合中将元素取出来，我们则可以知道取出来的元素肯定是T类型（全是它的子类）
   */
  @Test
  public void testExtends() {
    List<? extends T> extendsT = new ArrayList<>();
    // extendsT.add(new T()); // 报错 Required type: capture of ? extends T
    // extendsT.add(new Child1()); // 报错 Required type: capture of ? extends T
    // extendsT.add(new Parent1()); // 报错 Required type: capture of ? extends T
    // extendsT.add(new Parent2()); // 报错 Required type: capture of ? extends T
    // extendsT.add(new Object()); // 报错 Required type: capture of ? extends T
  }

  /**
   * Parent1
   *    ↑
   * Parent2
   *    ↑
   * Parent3
   *    ↑
   *    T
   *    ↑
   *  Child1
   *    ↑
   *  Child2
   *    ↑
   *  Child3
   */
  static class Parent1 {

  }

  static class Parent2 extends Parent1 {

  }

  static class Parent3 extends Parent2 {

  }

  static class T extends Parent3 {

  }

  static class Child1 extends T {

  }

  static class Child2 extends Child1 {

  }

  static class Child3 extends Child2 {

  }

}
