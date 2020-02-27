package com.bowen.hogwarts.leetcode;

import org.junit.Test;

public class ReverseWordsOfStringTest {

  @Test
  public void reverseWords() {
    String reverseWords = new ReverseWordsOfString().reverseWords("the sky is blue");
    System.out.println(reverseWords);
    assert "blue is sky the".equals(reverseWords);
  }

  @Test
  public void reverseWords2() {
    String reverseWords = new ReverseWordsOfString().reverseWords("  hello world!  ");
    System.out.println(reverseWords);
    assert "world! hello".equals(reverseWords);
  }

  @Test
  public void reverseWords3() {
    String reverseWords = new ReverseWordsOfString().reverseWords("a good   example");
    System.out.println(reverseWords);
    assert "example good a".equals(reverseWords);
  }
}