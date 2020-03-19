package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author zhaobaowen
 */
public class MergeIntervals {

  /**
   * 先将二位数组按照每个区间的左边界排序
   * 两种情况：
   *  1.这样后一个区间左边界大于前一个区间的右边界时，则说明两个区间无法合并，直接末尾追加
   *  2.如果后一个区间右边界大于前一个区间的右边界，则用后者的右边界覆盖掉前者的右边界
   *
   * 执行用时 :11 ms, 在所有 Java 提交中击败了37.46%的用户
   * 内存消耗 :42.3 MB, 在所有 Java 提交中击败了48.92%的用户
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    List<Integer> bounds = new ArrayList<>();
    for (int[] interval : intervals) {
      if (bounds.isEmpty() || interval[0] > bounds.get(bounds.size() - 1)) {
        bounds.add(interval[0]);
        bounds.add(interval[1]);
        continue;
      }
      if (interval[1] > bounds.get(bounds.size() - 1)) {
        bounds.set(bounds.size() - 1, interval[1]);
      }
    }
    int[][] result = new int[bounds.size() / 2][];
    for (int i = 0; i < bounds.size(); i = i + 2) {
      int[] interval = new int[2];
      interval[0] = bounds.get(i);
      interval[1] = bounds.get(i + 1);
      result[i / 2] = interval;
    }
    return result;
  }

}
