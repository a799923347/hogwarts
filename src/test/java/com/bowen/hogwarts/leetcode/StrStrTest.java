package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StrStrTest {

  @Test
  void strStr() {
    int i = new StrStr().strStr("hello", "ll");
    System.out.println(i);
    assert i == 2;
  }

  @Test
  void stxrStr2() {
    int i = new StrStr().strStr("aaaaa", "bba");
    System.out.println(i);
    assert i == -1;
  }
}