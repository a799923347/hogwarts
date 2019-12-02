package com.bowen.hogwarts.leetcode;


import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class LongestNoDupSubStringTest {

  @Test
  public void test() {
    String s = "abcabcbb";
    LongestNoDupSubString longestNoDupSubString = new LongestNoDupSubString();
    int i = longestNoDupSubString.lengthOfLongestSubstring(s);
    assert i == 3;
  }

  @Test
  public void test2() {
    String s = "bbbbb";
    LongestNoDupSubString longestNoDupSubString = new LongestNoDupSubString();
    int i = longestNoDupSubString.lengthOfLongestSubstring(s);
    assert i == 1;
  }

  @Test
  public void test3() {
    String s = "pwwkew";
    LongestNoDupSubString longestNoDupSubString = new LongestNoDupSubString();
    int i = longestNoDupSubString.lengthOfLongestSubstring(s);
    assert i == 3;
  }
}
