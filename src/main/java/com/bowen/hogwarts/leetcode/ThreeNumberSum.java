package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足
 * 条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class ThreeNumberSum {

  /**
   * 暴力求解，时间复杂度O(n^3)，超时
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> resultCollection = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> integers = Stream.of(nums[i], nums[j], nums[k]).sorted()
                .collect(Collectors.toList());
            if (set.add(integers.toString())) {
              resultCollection.add(integers);
            }
          }
        }
      }
    }
    return resultCollection;
  }

  /**
   * 先对数组排序，从当前锚定的目标nums[i]开始，锚定位置右方使用首尾指针向中间扫描，对比暴力解法，时间复杂度为O(n^2)
   * 执行用时 :53 ms, 在所有 java 提交中击败了46.62%的用户
   * 内存消耗 :46.5 MB, 在所有 java 提交中击败了96.07%的用户
   */
  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> resultCollection = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      if (nums[i] > 0) {
        break;
      }
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          resultCollection
              .add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
          while (left < right && nums[left + 1] == nums[left]) {
            left++;
          }
          while (left < right && nums[right - 1] == nums[right]) {
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return resultCollection;
  }
}
