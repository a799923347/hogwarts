package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestPalindromeTest {

  @Test
  void longestPalindrome() {
    String s = "babad";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String result = longestPalindrome.longestPalindrome(s);
    System.out.println(result);
    assert "bab".equals(result);
  }

  @Test
  void longestPalindrome2() {
    String s = "cbbd";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String result = longestPalindrome.longestPalindrome(s);
    System.out.println(result);
    assert "bb".equals(result);
  }

  /**
   * "babaddtattarrattatddetartrateedredividerb"
   */
  @Test
  void longestPalindrome3() {
    String s = "babaddtattarrattatddetartrateedredividerb";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String result = longestPalindrome.longestPalindrome(s);
    System.out.println(result);
    assert "ddtattarrattatdd".equals(result);
  }
}
