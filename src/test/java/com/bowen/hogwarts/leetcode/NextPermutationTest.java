package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NextPermutationTest {

  @Test
  void nextPermutation() {
    int[] nums = new int[]{1, 2, 3};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    assert "[1, 3, 2]".equals(Arrays.toString(nums));
  }

  @Test
  void nextPermutation2() {
    int[] nums = new int[]{3, 2, 1};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    assert "[1, 2, 3]".equals(Arrays.toString(nums));
  }

  @Test
  void nextPermutation3() {
    int[] nums = new int[]{1, 1, 5};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    assert "[1, 5, 1]".equals(Arrays.toString(nums));
  }

  @Test
  void nextPermutation4() {
    int[] nums = new int[]{1, 3, 2};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    assert "[2, 1, 3]".equals(Arrays.toString(nums));
  }

  @Test
  void nextPermutation5() {
    int[] nums = new int[]{2, 3, 1};
    new NextPermutation().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    assert "[3, 1, 2]".equals(Arrays.toString(nums));
  }
}