package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LetterCombinationsTest {

  @Test
  void letterCombinations() {
    List<String> strings = new LetterCombinations().letterCombinations("234");
    System.out.println(strings);
  }

  @Test
  void letterCombinations2() {
    List<String> strings = new LetterCombinations().letterCombinations("");
    System.out.println(strings);
  }
}