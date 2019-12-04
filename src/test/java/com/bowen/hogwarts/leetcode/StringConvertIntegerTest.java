package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class StringConvertIntegerTest {

  @Test
  void myAtoi() {
    int atoi = new StringConvertInteger().myAtoi("42");
    System.out.println(atoi);
    assert atoi == 42;
  }

  @Test
  void myAtoi2() {
    int atoi = new StringConvertInteger().myAtoi("   -42");
    System.out.println(atoi);
    assert atoi == -42;
  }

  @Test
  void myAtoi3() {
    int atoi = new StringConvertInteger().myAtoi("4193 with words");
    System.out.println(atoi);
    assert atoi == 4193;
  }

  @Test
  void myAtoi4() {
    int atoi = new StringConvertInteger().myAtoi("words and 987");
    System.out.println(atoi);
    assert atoi == 0;
  }

  @Test
  void myAtoi5() {
    int atoi = new StringConvertInteger().myAtoi("-91283472332");
    System.out.println(atoi);
    assert atoi == Integer.MIN_VALUE;
  }

  @Test
  void myAtoi6() {
    int atoi = new StringConvertInteger().myAtoi("-");
    System.out.println(atoi);
    assert atoi == 0;
  }

  @Test
  void myAtoi7() {
    int atoi = new StringConvertInteger().myAtoi("+1");
    System.out.println(atoi);
    assert atoi == 1;
  }

  @Test
  void myAtoi8() {
    int atoi = new StringConvertInteger().myAtoi("-5-");
    System.out.println(atoi);
    assert atoi == -5;
  }
}
