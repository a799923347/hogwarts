package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class IntegerToRomanStringTest {

  @Test
  void intToRoman() {
    String roman = new IntegerToRomanString().intToRoman(3);
    System.out.println(roman);
    assert "III".equals(roman);
  }

  @Test
  void intToRoman2() {
    String roman = new IntegerToRomanString().intToRoman(4);
    System.out.println(roman);
    assert "IV".equals(roman);
  }

  @Test
  void intToRoman3() {
    String roman = new IntegerToRomanString().intToRoman(9);
    System.out.println(roman);
    assert "IX".equals(roman);
  }

  @Test
  void intToRoman4() {
    String roman = new IntegerToRomanString().intToRoman(58);
    System.out.println(roman);
    assert "LVIII".equals(roman);
  }

  @Test
  void intToRoman5() {
    String roman = new IntegerToRomanString().intToRoman(1994);
    System.out.println(roman);
    assert "MCMXCIV".equals(roman);
  }
}
