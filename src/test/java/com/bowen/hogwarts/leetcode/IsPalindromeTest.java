package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class IsPalindromeTest {

  @Test
  void isPalindrome2() {
    boolean palindrome2 = new IsPalindrome().isPalindrome2(121);
    System.out.println(palindrome2);
    assert palindrome2;
  }
}
