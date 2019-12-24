package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoNumberDivideTest {

  @Test
  void divide() {
    int divide = new TwoNumberDivide().divide(10, 3);
    System.out.println(divide);
    assert divide == 3;
  }

  @Test
  void divide2() {
    int divide = new TwoNumberDivide().divide(7, -3);
    System.out.println(divide);
    assert divide == -2;
  }

  @Test
  void divide3() {
    int divide = new TwoNumberDivide().divide(0, 1);
    System.out.println(divide);
    assert divide == 0;
  }

  @Test
  void divide4() {
    int divide = new TwoNumberDivide().divide(-1, 1);
    System.out.println(divide);
    assert divide == -1;
  }

  @Test
  void divide5() {
    int divide = new TwoNumberDivide().divide(Integer.MAX_VALUE, 1);
    System.out.println(divide);
    assert divide == Integer.MAX_VALUE;
  }

  @Test
  void divide6() {
    int divide = new TwoNumberDivide().divide(Integer.MIN_VALUE, 1);
    System.out.println(divide);
    assert divide == Integer.MAX_VALUE;
  }
}