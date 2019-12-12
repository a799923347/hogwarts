package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void merge() {
    int[] nums1 = new int[]{1, 3, 5, 7, 9, 10, 11, 13};
    int[] nums2 = new int[]{1, 2, 4, 6, 8, 10};
    int[] merge = new MergeSort().merge(nums1, nums2);
    System.out.println(Arrays.toString(merge));
  }

  @Test
  void sort() {
    int length = 100;
    int[] nums = new int[length];
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      nums[i] = random.nextInt(length);
    }
    System.out.println(length + "个数字，排序前：");
    System.out.println(Arrays.toString(nums));
    int[] sort = new MergeSort().sort(nums);
    System.out.println("排序后：");
    System.out.println(Arrays.toString(sort));
  }
}