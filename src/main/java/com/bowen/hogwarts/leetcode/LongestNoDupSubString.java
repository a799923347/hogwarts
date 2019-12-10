package com.bowen.hogwarts.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class LongestNoDupSubString {

  /**
   * 执行结果：通过
   * 执行用时 :14 ms, 在所有 java 提交中击败了59.08%的用户
   * 内存消耗 :38.2 MB, 在所有 java 提交中击败了89.41%的用户
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    int maxLength = set.size();
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      set = new HashSet<>();
      int count = 0;
      for (int j = i; j < s.length(); j++) {
        if (set.add(s.charAt(j))) {
          count++;
          if (count == maxLength) {
            return maxLength;
          }
          if (count > result) {
            result = count;
          }
        } else {
          break;
        }
      }
    }
    return result;
  }

  /**
   * 滑动窗口
   * 执行用时 :12 ms, 在所有 java 提交中击败了68.97%的用户
   * 内存消耗 :36.3 MB, 在所有 java 提交中击败了98.00%的用户
   */
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
}
