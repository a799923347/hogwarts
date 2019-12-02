package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class MedianOfTwoOrderedArrayTest {

  @Test
  void findMedianSortedArrays() {
    int[] nums1 = new int[]{1, 3};
    int[] nums2 = new int[]{2};
    MedianOfTwoOrderedArray medianOfTwoOrderedArray = new MedianOfTwoOrderedArray();
    double median = medianOfTwoOrderedArray.findMedianSortedArrays(nums1, nums2);
    assert median == 2.0;
  }

  @Test
  void findMedianSortedArrays2() {
    int[] nums1 = new int[]{1, 2};
    int[] nums2 = new int[]{3, 4};
    MedianOfTwoOrderedArray medianOfTwoOrderedArray = new MedianOfTwoOrderedArray();
    double median = medianOfTwoOrderedArray.findMedianSortedArrays(nums1, nums2);
    assert median == 2.5;
  }

  @Test
  void findMedianSortedArrays3() {
    int[] nums1 = new int[]{2, 2, 2};
    int[] nums2 = new int[]{2, 2, 2, 2};
    MedianOfTwoOrderedArray medianOfTwoOrderedArray = new MedianOfTwoOrderedArray();
    double median = medianOfTwoOrderedArray.findMedianSortedArrays(nums1, nums2);
    assert median == 2.0;
  }
}
