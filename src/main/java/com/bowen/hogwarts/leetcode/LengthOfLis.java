package com.bowen.hogwarts.leetcode;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶:
 * 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author zhaobaowen
 */
public class LengthOfLis {
  /*
  length of longest increasing subsequence
   */

  /**
   * 动态规划
   * 数组 dp 用于记录已经计算过的序列中最长上升子序列的长度,
   * 设 0 <= left < right < n, n 为 nums 数组长度,
   * 如果存在 nums[right] > nums[left], 则一定有 dp[right] = dp[left] + 1,
   * 时间复杂度 O(n^2)
   */
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxAns = 1;
    for (int right = 1; right < dp.length; right++) {
      int maxVal = 0;
      for (int left = 0; left < right; left++) {
        if (nums[right] > nums[left]) {
          maxVal = Math.max(maxVal, dp[left]);
        }
      }
      dp[right] = maxVal + 1;
      maxAns = Math.max(maxAns, dp[right]);
    }
    return maxAns;
  }

}
