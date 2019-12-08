package com.bowen.hogwarts.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class BracketIsValid {

  /**
   * 使用栈的数据结构，利用入栈、出栈检查括号匹配
   * 执行用时 :4 ms, 在所有 java 提交中击败了40.67%的用户
   * 内存消耗 :34.5 MB, 在所有 java 提交中击败了83.85%的用户
   */
  public boolean isValid(String s) {
    Map<Character, Character> bracketPairMap = new HashMap(16){{
      put(')', '(');
      put('}', '{');
      put(']', '[');
    }};
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < chars.length; i++) {
      if (stack.empty()) {
        stack.push(chars[i]);
        continue;
      }
      Character pop = stack.pop();
      if (!pop.equals(bracketPairMap.get(chars[i]))) {
        stack.push(pop);
        stack.push(chars[i]);
      }
    }
    return stack.isEmpty();
  }

}
