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
   * 递归法
   * 时间复杂度：O(log(min(m,n)))，
   * 首先，查找的区间是 [0, m][0,m]。
   * 而该区间的长度在每次循环之后都会减少为原来的一半。
   * 所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))
   * 由于 m≤n，所以时间复杂度是 O(log(min(m,n)))。
   *
   * 空间复杂度：O(1)，
   * 我们只需要恒定的内存来存储 99 个局部变量， 所以空间复杂度为 O(1)。
   */
  public double findMedianSortedArrays2(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    // to ensure m<=n
    if (m > n) {
      int[] temp = A; A = B; B = temp;
      int tmp = m; m = n; n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j-1] > A[i]){
        // i is too small
        iMin = i + 1;
      }
      else if (i > iMin && A[i-1] > B[j]) {
        // i is too big
        iMax = i - 1;
      }
      else {
        // i is perfect
        int maxLeft = 0;
        if (i == 0) { maxLeft = B[j-1]; }
        else if (j == 0) { maxLeft = A[i-1]; }
        else { maxLeft = Math.max(A[i-1], B[j-1]); }
        if ( (m + n) % 2 == 1 ) { return maxLeft; }

        int minRight = 0;
        if (i == m) { minRight = B[j]; }
        else if (j == n) { minRight = A[i]; }
        else { minRight = Math.min(B[j], A[i]); }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

}
