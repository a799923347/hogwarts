package com.bowen.hogwarts.leetcode;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ba" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class StringCheckInclusion {

  /**
   * 使用数组数据结构来存储频率，而不是仅使用特殊的哈希表数据结构来存储字符出现的频率。给定字符串仅包含小写
   * 字母（'a'到'z'）。因此需要采用大小为 26 的数组。
   */
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1map[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      int[] s2map = new int[26];
      // j < s1.length()的控制条件很关键，控制在s2上的窗口大小为s1的长度
      for (int j = 0; j < s1.length(); j++) {
        s2map[s2.charAt(i + j) - 'a']++;
      }
      if (matches(s1map, s2map)) {
        return true;
      }
    }
    return false;
  }
  public boolean matches(int[] s1map, int[] s2map) {
    for (int i = 0; i < 26; i++) {
      if (s1map[i] != s2map[i]) {
        return false;
      }
    }
    return true;
  }

}
