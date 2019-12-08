package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateParenthesisTest {

  @Test
  void generateParenthesis() {
    List<String> strings = new GenerateParenthesis().generateParenthesis(2);
    System.out.println(strings);
  }
}