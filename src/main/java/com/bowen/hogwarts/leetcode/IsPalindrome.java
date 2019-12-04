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

  /**
   * 不将整数转成string的解法，利用数组检验对称性
   * 1、负数一定不是回文数
   * 2、将整数每一位放入数组中，首尾指针向中间扫描，检查对称性
   *
   * 执行用时 :9 ms, 在所有 java 提交中击败了98.71%的用户
   * 内存消耗 :36.3 MB, 在所有 java 提交中击败了96.50%的用户
   */
  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    // int类型最长不会超过10位
    int[] ints = new int[10];
    int count = 0;
    while (x != 0) {
      ints[count++] = x % 10;
      x /= 10;
    }
    for (int left = 0, right = count - 1; left <= right; left++, right--) {
      if (ints[left] == ints[right]) {
        continue;
      }
      return false;
    }
    return true;
  }

}
