package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class RomanStringToIntegerTest {

  @Test
  void romanToInt() {
    int result = new RomanStringToInteger().romanToInt("MCMXCIV");
    System.out.println(result);
    assert 1994 == result;
  }

  @Test
  void romanToInt2() {
    int result = new RomanStringToInteger().romanToInt("LVIII");
    System.out.println(result);
    assert 58 == result;
  }

  @Test
  void romanToInt3() {
    int result = new RomanStringToInteger().romanToInt("IX");
    System.out.println(result);
    assert 9 == result;
  }

  @Test
  void romanToInt4() {
    int result = new RomanStringToInteger().romanToInt("IV");
    System.out.println(result);
    assert 4 == result;
  }

  @Test
  void romanToInt5() {
    int result = new RomanStringToInteger().romanToInt("III");
    System.out.println(result);
    assert 3 == result;
  }
}
