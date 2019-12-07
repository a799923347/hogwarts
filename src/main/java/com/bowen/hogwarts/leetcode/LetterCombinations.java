package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class LetterCombinations {

  /**
   * 暴力求解，两两计算笛卡尔积
   * 执行用时 :1 ms, 在所有 java 提交中击败了96.72%的用户
   * 内存消耗 :36 MB, 在所有 java 提交中击败了73.55%的用户
   */
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return new ArrayList<>();
    }
    String[] stringLib = new String[]{"", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
        "wxyz"};
    String initString = stringLib[Character.getNumericValue(digits.charAt(0))];
    char[] initChars = initString.toCharArray();
    List<String> result = new ArrayList<>();
    for (char initChar : initChars) {
      result.add(String.valueOf(initChar));
    }
    for (int i = 1; i < digits.length(); i++) {
      List<String> cartesian = new ArrayList<>();
      for (String s : result) {
        char[] chars = stringLib[Character.getNumericValue(digits.charAt(i))].toCharArray();
        for (char aChar : chars) {
          cartesian.add(s.concat(String.valueOf(aChar)));
        }
      }
      result = cartesian;
    }
    return result;
  }

  private Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  private List<String> output = new ArrayList<>();

  public void backtrack(String combination, String nextDigits) {
    // if there is no more digits to check
    if (nextDigits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map
      // the next available digit
      String digit = nextDigits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, nextDigits.substring(1));
      }
    }
  }

  /**
   * 官方题解，回溯法
   * 执行用时 :1 ms, 在所有 java 提交中击败了96.72%的用户
   * 内存消耗 :35.7 MB, 在所有 java 提交中击败了76.78%的用户
   */
  public List<String> letterCombinations2(String digits) {
    if (digits.length() != 0) {
      backtrack("", digits);
    }
    return output;
  }

}
