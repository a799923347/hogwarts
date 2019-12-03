package com.bowen.hogwarts.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class ZShapeConvert {

  /**
   * 执行用时 :11 ms, 在所有 java 提交中击败了58.86%的用户
   * 内存消耗 :38.8 MB, 在所有 java 提交中击败了94.74%的用户
   */
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int numColumns = computeColumn(s, numRows);
    char[][] chars = new char[numRows][numColumns];
    int row = 0, column = 0;
    for (int i = 0; i < s.length(); i++) {
      int k = numRows + (numRows - 2);
      row = i % k % numRows;
      if (i % k == 0 && i != 0) {
        column++;
      }
      if ((i % k - numRows) >= 0) {
        column++;
        row = (numRows - 1) - (row + 1);
      }
      chars[row][column] = s.charAt(i);
    }
    StringBuilder resultBuilder = new StringBuilder();
    for (char[] aChar : chars) {
      for (char c : aChar) {
        if (c == '\0') {
          continue;
        }
        resultBuilder.append(c);
      }
    }
    printArray(chars);
    return resultBuilder.toString();
  }

  private int computeColumn(String s, int numRows) {
    int i = s.length() % (numRows + (numRows - 2));
    int m = s.length() / (numRows + (numRows - 2));
    if ((i - numRows) <= 0) {
      return m * (numRows - 1) + 1;
    } else {
      int n = i % numRows + 1;
      return m * (numRows - 1) + n;
    }
  }

  private void printArray(char[][] chars) {
    for (char[] aChar : chars) {
      for (char c : aChar) {
        if (c == '\0') {
          System.out.print(" ");
          continue;
        }
        System.out.print(c);
      }
      System.out.println();
    }
  }

  /**
   * 官方题解，按行访问
   *
   * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
   * 对于所有整数 k，
   * 行 0 中的字符位于索引 k(2*numRows−2) 处;
   * 行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1 处;
   * 内部的行 i 中的字符位于索引 k(2⋅numRows−2)+i  以及 (k+1)(2⋅numRows−2)−i 处;
   *
   * 执行用时 :4 ms, 在所有 java 提交中击败了95.61%的用户
   * 内存消耗 :36.6 MB, 在所有 java 提交中击败了99.58%的用户
   */
  public String convert2(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    StringBuilder ret = new StringBuilder();
    int n = s.length();
    int cycleLen = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < n; j += cycleLen) {
        ret.append(s.charAt(j + i));
        if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
          ret.append(s.charAt(j + cycleLen - i));
        }
      }
    }
    return ret.toString();
  }
}
