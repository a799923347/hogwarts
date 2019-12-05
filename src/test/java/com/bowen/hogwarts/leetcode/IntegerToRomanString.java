package com.bowen.hogwarts.leetcode;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class IntegerToRomanString {

  /**
   * 执行用时 :6 ms, 在所有 java 提交中击败了63.15%的用户
   * 内存消耗 :36.5 MB, 在所有 java 提交中击败了100.00%的用户
   */
  public String intToRoman(int num) {
    int thousPo, nineHundredPo, fiveHundredPo, fourHundredPo, oneHundredPo, ninetyPo, fiftyPo, fortyPo, tenPo, ninePo, fivePo, fourPo, onePo;
    String thousandMark = "M", nineHundredMark = "CM",
        fiveHundredMark = "D", fourHundredMark = "CD",
        oneHundredMark = "C", ninetyMark = "XC",
        fiftyMark = "L", fortyMark = "XL",
        tenMark = "X", nineMark = "IX",
        fiveMark = "V", fourMark = "IV", oneMark = "I";
    if ((thousPo = num / 1000) >= 1) {
      num %= 1000;
    }
    if ((nineHundredPo = num / 900) >= 1) {
      num %= 900;
    }
    if ((fiveHundredPo = num / 500) >= 1) {
      num %= 500;
    }
    if ((fourHundredPo = num / 400) >= 1) {
      num %= 400;
    }
    if ((oneHundredPo = num / 100) >= 1) {
      num %= 100;
    }
    if ((ninetyPo = num / 90) >= 1) {
      num %= 90;
    }
    if ((fiftyPo = num / 50) >= 1) {
      num %= 50;
    }
    if ((fortyPo = num / 40) >= 1) {
      num %= 40;
    }
    if ((tenPo = num / 10) >= 1) {
      num %= 10;
    }
    if ((ninePo = num / 9) >= 1) {
      num %= 9;
    }
    if ((fivePo = num / 5) >= 1) {
      num %= 5;
    }
    if ((fourPo = num / 4) >= 1) {
      num %= 4;
    }
    onePo = num;
    return repeat(thousandMark, thousPo)
        + repeat(nineHundredMark, nineHundredPo)
        + repeat(fiveHundredMark, fiveHundredPo)
        + repeat(fourHundredMark, fourHundredPo)
        + repeat(oneHundredMark, oneHundredPo)
        + repeat(ninetyMark, ninetyPo)
        + repeat(fiftyMark, fiftyPo)
        + repeat(fortyMark, fortyPo)
        + repeat(tenMark, tenPo)
        + repeat(nineMark, ninePo)
        + repeat(fiveMark, fivePo)
        + repeat(fourMark, fourPo)
        + repeat(oneMark, onePo);
  }

  private String repeat(String mark, int times) {
    if (times == 0) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < times; i++) {
      stringBuilder.append(mark);
    }
    return stringBuilder.toString();
  }

}
