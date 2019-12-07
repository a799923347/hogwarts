package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestSharedPrefixTest {

  @Test
  void longestCommonPrefix() {
    String[] strings = new String[]{"flower", "flow", "flight"};
    String longestCommonPrefix = new LongestSharedPrefix().longestCommonPrefix(strings);
    System.out.println(longestCommonPrefix);
    assert "fl".equals(longestCommonPrefix);
  }

  @Test
  void longestCommonPrefix2() {
    String[] strings = new String[]{"dog","racecar","car"};
    String longestCommonPrefix = new LongestSharedPrefix().longestCommonPrefix(strings);
    System.out.println(longestCommonPrefix);
    assert "".equals(longestCommonPrefix);
  }

  @Test
  void longestCommonPrefix3() {
    String[] strings = new String[]{"aa","a"};
    String longestCommonPrefix = new LongestSharedPrefix().longestCommonPrefix(strings);
    System.out.println(longestCommonPrefix);
    assert "a".equals(longestCommonPrefix);
  }
}