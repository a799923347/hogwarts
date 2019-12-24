package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoNumberDivideTest {

  @Test
  void divide() {
    int divide = new TwoNumberDivide().divide2(10, 3);
    System.out.println(divide);
    assert divide == 3;
  }

  @Test
  void divide2() {
    int divide = new TwoNumberDivide().divide2(7, -3);
    System.out.println(divide);
    assert divide == -2;
  }

  @Test
  void divide3() {
    int divide = new TwoNumberDivide().divide2(0, 1);
    System.out.println(divide);
    assert divide == 0;
  }

  @Test
  void divide4() {
    int divide = new TwoNumberDivide().divide2(-1, 1);
    System.out.println(divide);
    assert divide == -1;
  }

  @Test
  void divide5() {
    int divide = new TwoNumberDivide().divide2(Integer.MAX_VALUE, 1);
    System.out.println(divide);
    assert divide == Integer.MAX_VALUE;
  }

  @Test
  void divide6() {
    int divide = new TwoNumberDivide().divide2(Integer.MIN_VALUE, 1);
    System.out.println(divide);
    assert divide == Integer.MIN_VALUE;
  }

  @Test
  void divide7() {
    int divide = new TwoNumberDivide().divide2(1, 1);
    System.out.println(divide);
    assert divide == 1;
  }

  @Test
  void divide8() {
    int divide = new TwoNumberDivide().divide2(Integer.MIN_VALUE, 2);
    System.out.println(divide);
    assert divide == -1073741824;
  }

  @Test
  void divide9() {
    int divide = new TwoNumberDivide().divide2(Integer.MIN_VALUE, -1);
    System.out.println(divide);
    assert divide == Integer.MAX_VALUE;
  }
}