package com.bowen.hogwarts.sort;

/**
 * 快速排序
 *
 * @author zhaobaowen
 */
public class QuickSort {

  public void sort(int[] nums) {
    recursiveDivide(nums, 0, nums.length - 1);
  }

  private void recursiveDivide(int[] nums, int start, int pivot) {
    if (start >= pivot) {
      return;
    }
    int i = start;
    for (int j = start; j < pivot; j++) {
      if (nums[j] < nums[pivot]) {
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, pivot);
    recursiveDivide(nums, start, i - 1);
    recursiveDivide(nums, i + 1, pivot);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
