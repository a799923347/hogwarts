package com.bowen.hogwarts.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class TwoNumberDivide {

  /**
   * 使用加减法，时间复杂度O(dividend/divisor)，超时
   */
  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    if (dividend == Integer.MIN_VALUE && divisor == 1) {
      return Integer.MIN_VALUE;
    }
    int counter = 0;
    boolean positive = (dividend >= 0 && divisor >= 0) || (dividend <= 0 && divisor <= 0);
    int temp = dividend;
    while (temp == 0 || (dividend >> 31) == (temp >> 31)) {
      if (positive) {
        temp = temp - divisor;
      } else {
        temp = temp + divisor;
      }
      counter++;
    }
    return positive ? (counter - 1) : (1 - counter);
  }

}
