package com.bowen.hogwarts.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class ReverseWordsOfString {

  /**
   * 去掉头尾空格，根据空格分隔，再过滤掉空对象，使用首尾指针向中间扫描，扫描过程中首尾指针指向的内容进行交换
   * 使用了很多额外的存储空间，空间复杂度非常高
   * 执行用时 :4 ms, 在所有 Java 提交中击败了60.43%的用户
   * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.10%的用户
   */
  public String reverseWords(String s) {
    String[] strings = s.trim().split(" ");
    List<String> collect = Stream.of(strings).filter(ele -> !"".equals(ele))
        .collect(Collectors.toList());
    for (int i = 0, j = collect.size() - 1; i < j; i++, j--) {
      String temp = collect.get(i);
      collect.set(i, collect.get(j));
      collect.set(j, temp);
    }
    return String.join(" ", collect);
  }

}
