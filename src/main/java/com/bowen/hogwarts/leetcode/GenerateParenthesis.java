package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class GenerateParenthesis {

  /**
   * 回溯法
   * 执行用时 :1 ms, 在所有 java 提交中击败了99.39%的用户
   * 内存消耗 :36.2 MB, 在所有 java 提交中击败了99.07%的用户
   */
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, String concat, int open, int close, int max) {
    if (concat.length() == max * 2) {
      ans.add(concat);
      return;
    }

    if (open < max) {
      backtrack(ans, concat + "(", open + 1, close, max);
    }
    if (close < open) {
      backtrack(ans, concat + ")", open, close + 1, max);
    }
  }

}
