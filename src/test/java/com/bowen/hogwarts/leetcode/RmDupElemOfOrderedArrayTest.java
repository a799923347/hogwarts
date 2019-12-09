package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RmDupElemOfOrderedArrayTest {

  @Test
  void removeDuplicates() {
    int[] nums = new int[]{1, 1, 2};
    int counter = new RmDupElemOfOrderedArray().removeDuplicates(nums);
    System.out.println(counter);
    System.out.println(Arrays.toString(nums));
    assert counter == 2;
  }

  @Test
  void removeDuplicates2() {
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int counter = new RmDupElemOfOrderedArray().removeDuplicates(nums);
    System.out.println(counter);
    System.out.println(Arrays.toString(nums));
    assert counter == 5;
  }

  @Test
  void removeDuplicates3() {
    int[] nums = new int[]{1, 1};
    int counter = new RmDupElemOfOrderedArray().removeDuplicates(nums);
    System.out.println(counter);
    System.out.println(Arrays.toString(nums));
    assert counter == 1;
  }

  @Test
  void removeDuplicates4() {
    int[] nums = new int[]{1, 1, 2, 3};
    int counter = new RmDupElemOfOrderedArray().removeDuplicates(nums);
    System.out.println(counter);
    System.out.println(Arrays.toString(nums));
    assert counter == 3;
  }
}