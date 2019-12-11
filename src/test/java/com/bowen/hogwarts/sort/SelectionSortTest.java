package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

  @Test
  void sort() {
    int[] nums = new int[]{9, 3, 5, 2, 8, 5, 6, 4};
    new SelectionSort().sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}