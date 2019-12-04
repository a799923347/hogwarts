package com.bowen.hogwarts.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class IsPalindrome {

  /**
   * 执行用时 :13 ms, 在所有 java 提交中击败了42.34%的用户
   * 内存消耗 :36.8 MB, 在所有 java 提交中击败了91.65%的用户
   */
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    int length = s.length();
    if (length % 2 == 0) {
      String left = s.substring(0, length / 2);
      String right = s.substring(length / 2);
      return left.equals(new StringBuilder(right).reverse().toString());
    } else {
      String left = s.substring(0, length / 2 + 1);
      String right = s.substring(length / 2);
      return left.equals(new StringBuilder(right).reverse().toString());
    }
  }

}
