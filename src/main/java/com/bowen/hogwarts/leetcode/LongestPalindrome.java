package com.bowen.hogwarts.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1： 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2： 输入: "cbbd" 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class LongestPalindrome {

  /*
   * 递归
   *                                        babad
   *                                         / \
   *                                       /    \
   *                                     baba  abad
   *                                     / \     /\
   *                                    /   \   /  \
   *                                  bab  aba aba bad
   *                                  return "bab"
   * 超时
   */

  private int currentAnsLeg = 1;

  public String longestPalindrome(String s) {
    if (s.length() < currentAnsLeg) {
      return "";
    }
    int length = s.length();
    if (length == 1) {
      return s;
    }
    if (length % 2 == 0) {
      String left = s.substring(0, length / 2);
      String right = s.substring(length / 2);
      if (left.equals(new StringBuilder(right).reverse().toString())) {
        currentAnsLeg = s.length();
        return s;
      }
    } else {
      String left = s.substring(0, length / 2 + 1);
      String right = s.substring(length / 2);
      if (left.equals(new StringBuilder(right).reverse().toString())) {
        currentAnsLeg = s.length();
        return s;
      }
    }
    String former = longestPalindrome(s.substring(0, s.length() - 1));
    String latter = longestPalindrome(s.substring(1));
    return former.length() >= latter.length() ? former : latter;
  }

}
