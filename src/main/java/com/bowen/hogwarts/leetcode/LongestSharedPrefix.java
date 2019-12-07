package com.bowen.hogwarts.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class LongestSharedPrefix {

  /**
   * 执行用时 :1 ms, 在所有 java 提交中击败了90.30%的用户
   * 内存消耗 :37.7 MB, 在所有 java 提交中击败了72.15%的用户
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String firstString = strs[0];
    for (int i = 0; i < firstString.length(); i++) {
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || firstString.charAt(i) != strs[j].charAt(i)) {
          // 如果超出长度或者字符不匹配，则返回
          return firstString.substring(0, i);
        }
      }
    }
    return firstString;
  }

}
