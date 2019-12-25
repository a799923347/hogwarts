package com.bowen.hogwarts.leetcode;

import org.junit.jupiter.api.Test;

class SearchRotatedOrderedArrayTest {

  @Test
  void search() {
    int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    int search = new SearchRotatedOrderedArray().search(nums, 0);
    System.out.println(search);
    assert search == 4;
  }

  @Test
  void search2() {
    int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    int search = new SearchRotatedOrderedArray().search(nums, 3);
    System.out.println(search);
    assert search == -1;
  }
}