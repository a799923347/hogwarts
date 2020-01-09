package com.bowen.hogwarts.sort;

/**
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 1. 选择一个增量序列t_1，t_2，…，t_k，其中 t_i > t_j，t_k=1；
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子
 * 为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * @author zhaobaowen
 */
public class ShellSort {

  public void sort(int[] nums) {
    for (int gap = nums.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < nums.length; i++) {
        int j = i - gap;
        int temp = nums[i];
        while (j >= 0 && temp < nums[j]) {
          nums[j + gap] = nums[j];
          j -= gap;
        }
        nums[j + gap] = temp;
      }
    }
  }
}
