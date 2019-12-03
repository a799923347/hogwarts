package com.bowen.hogwarts.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class ZShapeConvertTest {

  @Test
  void convert() {
    String s = "LEETCODEISHIRING";
    ZShapeConvert zShapeConvert = new ZShapeConvert();
    String convert = zShapeConvert.convert(s, 3);
    System.out.println(convert);
    assert "LCIRETOESIIGEDHN".equals(convert);
  }

  @Test
  void convert2() {
    String s = "LEETCODEISHIRING";
    ZShapeConvert zShapeConvert = new ZShapeConvert();
    String convert = zShapeConvert.convert(s, 4);
    System.out.println(convert);
    assert "LDREOEIIECIHNTSG".equals(convert);
  }

  @Test
  void convert3() {
    String s = "";
    ZShapeConvert zShapeConvert = new ZShapeConvert();
    String convert = zShapeConvert.convert(s, 1);
    System.out.println(convert);
    assert "".equals(convert);
  }
}
