package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StringMultiplyTest {

  @Test
  void multiply() {
    String multiply = new StringMultiply().multiply("123", "456");
    System.out.println(multiply);
    assert "56088".equals(multiply);
  }

  @Test
  void multiply2() {
    String multiply = new StringMultiply().multiply("2", "3");
    System.out.println(multiply);
    assert "6".equals(multiply);
  }

  @Test
  void multiply3() {
    String multiply = new StringMultiply().multiply("9", "9");
    System.out.println(multiply);
    assert "81".equals(multiply);
  }

  @Test
  void multiply4() {
    String multiply = new StringMultiply().multiply("999", "999");
    System.out.println(multiply);
    assert "998001".equals(multiply);
  }
}