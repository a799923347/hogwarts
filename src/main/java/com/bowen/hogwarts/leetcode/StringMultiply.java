package com.bowen.hogwarts.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class StringMultiply {

  /**
   * 基本就是手算乘法时那套计算方法的实现
   *
   * 执行用时 :6 ms, 在所有 java 提交中击败了71.20%的用户
   * 内存消耗 :36.3 MB, 在所有 java 提交中击败了90.45%的用户
   */
  public String multiply(String num1, String num2) {
    String zero = "0";
    if (zero.equals(num1) || zero.equals(num2)) {
      return zero;
    }
    int cols = num1.length() + num2.length();
    int[] bitResult = new int[cols];
    int rows = Math.min(num1.length(), num2.length());
    // 用于按位相乘时记录乘积
    int[][] assist = new int[rows][cols];
    // 确保num1的长度不短于num2
    if (num1.length() < num2.length()) {
      String temp = num1;
      num1 = num2;
      num2 = temp;
    }
    // 将num1由string转为int数组
    int[] num1Array = new int[num1.length()];
    for (int i = 0; i < num1.length(); i++) {
      num1Array[i] = Integer.parseInt(num1.substring(i, i + 1));
    }
    // 按位相乘，结果记录在assist数组中
    for (int i = rows - 1; i >= 0; i--) {
      bitMultiply((rows - 1) - i, assist, num1Array, Integer.parseInt(num2.substring(i, i + 1)));
    }
    // 将assist数组中的值按列进行累加
    int carry = 0;
    for (int col = 0; col < cols; col++) {
      for (int row = 0; row < rows; row++) {
        bitResult[col] = bitResult[col] + assist[row][col];
      }
      if (carry > 0) {
        bitResult[col] = bitResult[col] + carry;
      }
      carry = bitResult[col] / 10;
      bitResult[col] = bitResult[col] % 10;
    }
    // 由于之前计算乘法的过程中，值是反向存储的，所以此处需要进行reverse
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = bitResult.length - 1; i >= 0; i--) {
      stringBuilder.append(bitResult[i]);
    }
    String stringResult = stringBuilder.toString();
    int index = 0;
    for (int i = 0; '0' == stringResult.charAt(i); i++) {
      index++;
    }
    return stringResult.substring(index);
  }

  private void bitMultiply(int row, int[][] assist, int[] num1Array, int multiplier) {
    int carry = 0;
    for (int i = num1Array.length - 1, col = 0; i >= 0; i--, col++) {
      int product = num1Array[i] * multiplier;
      if (carry > 0) {
        product = product + carry;
      }
      carry = product / 10;
      assist[row][col + row] = product % 10;
    }
    if (carry > 0) {
      assist[row][row + num1Array.length] = carry;
    }
  }

}
