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

  /**
   * 解题思路：这题是除法，所以先普及下除法术语
   * 商，公式是：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，是一种数学术语。
   * 在一个除法算式里，被除数、余数、除数和商的关系为：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，
   * 进而推导得出：商×除数+余数=被除数。
   *
   * 要求商，我们首先想到的是减法，能被减多少次，那么商就为多少，但是明显减法的效率太低
   *
   * 那么我们可以用位移法，因为计算机在做位移时效率特别高，向左移1相当于乘以2，向右位移1相当于除以2
   *
   * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
   *
   * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
   *
   * 我们可以以100/3为例
   *
   * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
   *
   * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
   *
   * 所以一共是减去了33个3，所以商就是33
   *
   * 这其中得处理一些特殊的数，比如divisor是不能为0的，Integer.MIN_VALUE和Integer.MAX_VALUE
   *
   * tips：起初将数字全都取绝对值取计算，但是Integer.MIN_VALUE转成正数有溢出问题，所以反其道行之，取负数来计算
   * 执行用时 :2 ms, 在所有 java 提交中击败了63.33%的用户
   * 内存消耗 :33.5 MB, 在所有 java 提交中击败了78.81%的用户
   */
  public int divide2(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    if (dividend == Integer.MIN_VALUE && divisor == 1) {
      return Integer.MIN_VALUE;
    }
    boolean positive = (dividend >> 31 ^ divisor >> 31) == 0;
    int value = backTrack(-Math.abs(dividend), -Math.abs(divisor));
    return positive ? value : -value;
  }

  private int backTrack(int dividend, int divisor) {
    if (dividend > divisor) {
      return 0;
    }
    int quotient;
    for (int i = 31; i >= 0; i--) {
      if ((dividend >> i) < divisor) {
        quotient = 1 << i;
        return quotient + backTrack(dividend - (divisor << i), divisor);
      }
    }
    return 1;
  }

}
