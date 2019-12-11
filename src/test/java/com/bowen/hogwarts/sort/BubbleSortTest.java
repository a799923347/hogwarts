package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

  @Test
  void sort() {
    int[] nums = new int[]{3, 5, 2, 8, 5, 6, 4};
    new BubbleSort().sort(nums);
    System.out.println(Arrays.toString(nums));
  }
}