package com.bowen.hogwarts.sort;

/**
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * 1. 初始状态：无序区为R[1..n]，有序区为空；
 * 2. 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出
 * 关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序
 * 区和记录个数减少1个的新无序区；
 * 3. n-1趟结束，数组有序化了。
 *
 * 选择排序是不稳定的，比如
 * 序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了
 * @author zhaobaowen
 */
public class SelectionSort {

  public void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[minIndex] > nums[j]) {
          minIndex = j;
        }
      }
      int temp = nums[minIndex];
      nums[minIndex] = nums[i];
      nums[i] = temp;
    }
  }
}
