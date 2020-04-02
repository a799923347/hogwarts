package com.bowen.hogwarts.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1: nums1 = [1, 3] nums2 = [2] 则中位数是 2.0
 *
 * 示例 2: nums1 = [1, 2] nums2 = [3, 4] 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class MedianOfTwoOrderedArray {

  /**
   * 执行用时 :3 ms, 在所有 java 提交中击败了98.67%的用户
   * 内存消耗 :47.2 MB, 在所有 java 提交中击败了93.81%的用户
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0) {
      return medianOf(nums2);
    }
    if (nums2 == null || nums2.length == 0) {
      return medianOf(nums1);
    }
    int totalNums = nums1.length + nums2.length;
    int position = totalNums / 2;
    int i = 0, j = 0, count = 0;
    // 两个数组总长为奇数
    if (totalNums % 2 == 1) {
      while (true) {
        int temp1 = i >= nums1.length ? Integer.MAX_VALUE : nums1[i];
        int temp2 = j >= nums2.length ? Integer.MAX_VALUE : nums2[j];
        if (temp1 > temp2) {
          if (count == position) {
            return temp2;
          }
          j++;
        } else {
          if (count == position) {
            return temp1;
          }
          i++;
        }
        count++;
      }
    }
    // 两个数组总长为偶数
    int a = 0, b = 0;
    while (true) {
      int temp1 = i >= nums1.length ? Integer.MAX_VALUE : nums1[i];
      int temp2 = j >= nums2.length ? Integer.MAX_VALUE : nums2[j];
      if (temp1 > temp2) {
        if (count == position - 1) {
          a = temp2;
        }
        if (count == position) {
          b = temp2;
        }
        j++;
      } else {
        if (count == position - 1) {
          a = temp1;
        }
        if (count == position) {
          b = temp1;
        }
        i++;
      }
      if (count == position) {
        return (a + b) / 2.0;
      }
      count++;
    }
  }

  private double medianOf(int[] nums) {
    int size = nums.length;
    if (size % 2 == 0) {
      return (nums[(size >> 1) - 1] + nums[size >> 1]) / 2.0;
    }
    return nums[size >> 1];
  }

  /**
   *
   * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
   * 内存消耗 :41 MB, 在所有 Java 提交中击败了98.55%的用户
   */
  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    // to ensure m<=n
    // 保证A数组一定是较短的数组
    if (m > n) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
      int tmp = m;
      m = n;
      n = tmp;
    }
    // iMin、iMax 是数组1的两个游标
    // halfLen：中位数在两个数组中确切的位置
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      // j 的位置与 i 是关于 halfLen 联动的
      int j = halfLen - i;
      if (i < iMax && nums2[j - 1] > nums1[i]) {
        // i is too small
        // 数组2的左边部分最大值 > 数组1右边部分的最小值，则说明 iMin 游标位置偏小，将 iMin 右移
        iMin = i + 1;
      } else if (i > iMin && nums1[i - 1] > nums2[j]) {
        // i is too big
        // 数组1左边部分的最大值 > 数组2右边部分的最小值，则说明 iMax 右边位置偏大，将 iMax 左移
        iMax = i - 1;
      } else {
        // i is perfect
        // 这个时候 i、j 的位置刚刚好，nums2[j - 1] <= nums1[i] 且 nums1[i - 1] <= nums2[j]
        int maxLeft = 0;
        if (i == 0) {
          // i == 0 说明整个数组左边部分全部由 数组2 中的左边部分组成
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          // j == 0 说明整个数组左边部分全部由 数组1 中的左边部分组成
          maxLeft = nums1[i - 1];
        } else {
          // 整个数组的左边部分由 数组1 的左边部分和 数组2 的左边部分共同组成，
          // 所以取 nums1[i - 1] 和 nums2[j - 1] 两个较大的值
          maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        // 如果两个数组总长度为奇数，则直接返回 maxLeft，
        // 因为 halfLen = (m + n + 1) / 2，
        // 而 int j = halfLen - i，
        // 所以总长度为奇数时 maxLeft 就是中位数
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        // 总长度为偶数，还需要再判断出右边最小的的值
        int minRight = 0;
        if (i == m) {
          // i == m 则说明整个数组的右边部分全部由 数组2 的右边部分组成
          minRight = nums2[j];
        } else if (j == n) {
          // j == n 则说明整个数组的右边部分全部由 数组1 的右边部分组成
          minRight = nums1[i];
        } else {
          // 整个数组的右边部分由 数组1 的右边部分和 数组2 的右边部分共同组成
          // 所以取 nums2[j] 和 nums1[i] 中较小的值
          minRight = Math.min(nums2[j], nums1[i]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

}
