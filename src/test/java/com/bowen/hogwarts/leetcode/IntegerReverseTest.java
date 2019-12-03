package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class IntegerReverseTest {

  @Test
  void reverse() {
    IntegerReverse integerReverse = new IntegerReverse();
    int reverse = integerReverse.reverse(123);
    System.out.println(reverse);
    assert 321 == reverse;
  }

  @Test
  void reverse2() {
    IntegerReverse integerReverse = new IntegerReverse();
    int reverse = integerReverse.reverse(-123);
    System.out.println(reverse);
    assert -321 == reverse;
  }

  @Test
  void reverse3() {
    IntegerReverse integerReverse = new IntegerReverse();
    int reverse = integerReverse.reverse(120);
    System.out.println(reverse);
    assert 21 == reverse;
  }

  @Test
  void reverse4() {
    IntegerReverse integerReverse = new IntegerReverse();
    int reverse = integerReverse.reverse(1534236469);
    System.out.println(reverse);
    assert 0 == reverse;
  }

  @Test
  void reverse5() {
    IntegerReverse integerReverse = new IntegerReverse();
    int reverse = integerReverse.reverse(-2147483648);
    System.out.println(reverse);
    assert 0 == reverse;
  }
}
