package com.bowen.hogwarts.sort;

/**
 * 归并排序
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应
 * 用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一
 * 个有序表，称为2-路归并。
 *
 * 算法步骤：
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * @author zhaobaowen
 */
public class MergeSort {

  public int[] sort(int[] nums) {
    return divideArray(nums, 0, nums.length - 1);
  }

  private int[] divideArray(int[] nums, int start, int end) {
    if (start >= end) {
      return new int[]{nums[start]};
    }
    int middle = (end + start) / 2;
    return merge(divideArray(nums, start, middle), divideArray(nums, middle + 1, end));
  }

  int[] merge(int[] nums1, int[] nums2) {
    int counter1 = 0, counter2 = 0, resultCounter = 0;
    int[] resultArray = new int[nums1.length + nums2.length];
    while (counter1 < nums1.length || counter2 < nums2.length) {
      int value1 = counter1 >= nums1.length ? Integer.MAX_VALUE : nums1[counter1];
      int value2 = counter2 >= nums2.length ? Integer.MAX_VALUE : nums2[counter2];
      if (value1 < value2) {
        resultArray[resultCounter] = value1;
        counter1++;
      } else {
        resultArray[resultCounter] = value2;
        counter2++;
      }
      resultCounter++;
    }
    return resultArray;
  }

}
