package com.bowen.hogwarts.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2^31) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class StringConvertInteger {

  /**
   * 执行用时 :5 ms, 在所有 java 提交中击败了40.41%的用户
   * 内存消耗 :36.3 MB, 在所有 java 提交中击败了83.89%的用户
   */
  public int myAtoi(String str) {
    String trim = str.trim();
    if (trim.length() == 0 || Character.isAlphabetic(trim.charAt(0))) {
      return 0;
    }
    int result = 0;
    boolean negative = false, startAccum = false;
    int signCount = 0;
    for (int i = 0; i < trim.length(); i++) {
      boolean signPosition = '-' == trim.charAt(i) || '+' == trim.charAt(i);
      if (signPosition) {
        if (signCount >= 1 && !startAccum) {
          return 0;
        }
        signCount++;
        if (startAccum) {
          break;
        }
        negative = '-' == trim.charAt(i);
        continue;
      }
      if (!Character.isDigit(trim.charAt(i))) {
        break;
      }
      int numericValue = Character.getNumericValue(trim.charAt(i));
      boolean exceedMaxInt =
          !negative && (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result
              && Integer.MAX_VALUE % 10 < numericValue));
      if (exceedMaxInt) {
        return Integer.MAX_VALUE;
      }
      boolean exceedMinInt =
          negative && (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result
              && Integer.MAX_VALUE % 10 < numericValue - 1));
      if (exceedMinInt) {
        return Integer.MIN_VALUE;
      }
      result = result * 10 + numericValue;
      startAccum = true;
    }
    return negative ? -result : result;
  }

  /**
   * 正则解法
   * 执行用时 :15 ms, 在所有 java 提交中击败了9.41%的用户
   * 内存消耗 :37.1 MB, 在所有 java 提交中击败了81.31%的用户
   */
  public int myAtoi2(String str) {
    Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
    Matcher matcher = pattern.matcher(str.trim());
    if (!matcher.find()) {
      return 0;
    }
    String group = matcher.group();
    boolean negative = false;
    if (group.charAt(0) == '-') {
      negative = true;
      group = group.substring(1);
    } else if (group.charAt(0) == '+') {
      group = group.substring(1);
    }
    int result = 0;
    for (int i = 0; i < group.length(); i++) {
      int numericValue = Character.getNumericValue(group.charAt(i));
      boolean exceedMaxInt =
          !negative && (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result
              && Integer.MAX_VALUE % 10 < numericValue));
      if (exceedMaxInt) {
        return Integer.MAX_VALUE;
      }
      boolean exceedMinInt =
          negative && (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result
              && Integer.MAX_VALUE % 10 < numericValue - 1));
      if (exceedMinInt) {
        return Integer.MIN_VALUE;
      }
      result = result * 10 + numericValue;
    }
    return negative ? -result : result;
  }

}
