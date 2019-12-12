package com.bowen.hogwarts.utils;

import java.util.Random;

/**
 * @author zhaobaowen
 */
public class ArrayGenerateUtil {


  public static int[] randomIntArrays(int length) {
    int[] nums = new int[length];
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      nums[i] = random.nextInt(length);
    }
    return nums;
  }

}
