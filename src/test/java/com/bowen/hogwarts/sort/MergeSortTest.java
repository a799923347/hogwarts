package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
    int[] nums = new int[]{8, 2, 3, 4, 1, 9, 0, 7, 11, 3, 30, 21, 34, 15, 28, 18, 5, 16, 6, 10};
    int[] sort = new MergeSort().sort(nums);
    System.out.println(Arrays.toString(sort));
  }
}