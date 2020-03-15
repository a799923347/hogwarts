package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLengthOfLCISTest {

  @Test
  public void findLengthOfLCIS() {
    int[] nums = {1, 3, 5, 4, 7};
    int lengthOfLCIS = new FindLengthOfLCIS().findLengthOfLCIS(nums);
    System.out.println("连续递增序列最长长度：" + lengthOfLCIS);
    assert lengthOfLCIS == 3;
  }

  @Test
  public void findLengthOfLCIS2() {
    int[] nums = {1, 3, 5, 7, 9};
    int lengthOfLCIS = new FindLengthOfLCIS().findLengthOfLCIS(nums);
    System.out.println("连续递增序列最长长度：" + lengthOfLCIS);
    assert lengthOfLCIS == 5;
  }
}