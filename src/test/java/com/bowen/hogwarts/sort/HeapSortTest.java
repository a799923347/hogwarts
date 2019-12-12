package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import com.bowen.hogwarts.utils.ArrayGenerateUtil;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class HeapSortTest {

  @Test
  void sort() {
    int[] nums = ArrayGenerateUtil.randomIntArrays(30);
    System.out.println("排序前：");
    System.out.println(Arrays.toString(nums));
    new HeapSort().sort(nums);
    System.out.println("排序后：");
    System.out.println(Arrays.toString(nums));
  }
}