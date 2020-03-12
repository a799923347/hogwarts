package com.bowen.hogwarts.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class SearchRotatedOrderedArray {

  /**
   * 由于要求时间复杂度必须是 O(log n) 级别，所以第一反应应该是使用二分法求解，此处由于给定的数列是在一个单调递增
   * 的数列的基础上经过在某个位置上进行旋转所得，所以只能保证一定范围的单调性，所以将经典的二分查找进行一定改造
   *
   * 执行用时 :1 ms, 在所有 java 提交中击败了86.21%的用户
   * 内存消耗 :36.5 MB, 在所有 java 提交中击败了84.91%的用户
   */
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start == end) {
      return nums[start] == target ? start : -1;
    }
    int middle = (start + end) / 2;
    if (nums[middle] == target) {
      return middle;
    }
    // start与end之间的数组是单调递增的且target在数组边界范围内
    if (nums[start] < nums[end] && target >= nums[start] && target <= nums[end]) {
      if (target < nums[middle]) {
        return binarySearch(nums, start, middle, target);
      } else {
        return binarySearch(nums, middle + 1, end, target);
      }
    } else {
      // 此分支用于处理非单调的数组区间
      int left = binarySearch(nums, start, middle, target);
      if (left != -1) {
        return left;
      }
      return binarySearch(nums, middle + 1, end, target);
    }
  }

}
