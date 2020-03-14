package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class RestoreIpAddresses {

  List<String> ips = new ArrayList<>();
  private String delimiter = ".";

  /**
   * 类似爬楼梯问题
   * 执行用时 :3 ms, 在所有 Java 提交中击败了83.63%的用户
   * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了5.08%的用户
   */
  public List<String> restoreIpAddresses(String s) {
    if ("".equals(s) || s == null || s.length() < 4) {
      return ips;
    }
    parseIpAddress(1, "", s.substring(0, 1), s.substring(1));
    parseIpAddress(1, "", s.substring(0, 2), s.substring(2));
    if (Integer.parseInt(s.substring(0, 3)) <= 255) {
      parseIpAddress(1, "", s.substring(0, 3), s.substring(3));
    }
    return ips;
  }

  private void parseIpAddress(int level, String origin, String append, String s) {
    if ("".equals(s) || (Integer.parseInt(append) > 0 && append.startsWith("0")) || append
        .startsWith("00")) {
      return;
    }
    if (level == 3) {
      if (s.length() <= 3 && Integer.parseInt(s) <= 255 && !(s.startsWith("0")
          && Integer.parseInt(s) != 0) && !s
          .startsWith("00")) {
        ips.add(String.join(delimiter, origin, append, s).substring(1));
      }
      return;
    }
    parseIpAddress(level + 1, String.join(delimiter, origin, append), s.substring(0, 1),
        s.substring(1));
    if (s.length() >= 2) {
      parseIpAddress(level + 1, String.join(delimiter, origin, append), s.substring(0, 2),
          s.substring(2));
    }
    if (s.length() >= 3 && Integer.parseInt(s.substring(0, 3)) <= 255) {
      parseIpAddress(level + 1, String.join(delimiter, origin, append), s.substring(0, 3),
          s.substring(3));
    }
  }

}
