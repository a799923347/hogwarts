package com.bowen.hogwarts.sort;

import static org.junit.jupiter.api.Assertions.*;

import com.bowen.hogwarts.utils.ArrayGenerateUtil;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class QuickSortTest {

  @Test
  void sort() {
    int[] randomIntArrays = ArrayGenerateUtil.randomIntArrays(30);
    System.out.println("排序前：");
    System.out.println(Arrays.toString(randomIntArrays));
    new QuickSort().sort(randomIntArrays);
    System.out.println("排序后：");
    System.out.println(Arrays.toString(randomIntArrays));
  }
}