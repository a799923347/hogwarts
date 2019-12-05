package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author shachi
 */
class MaxAreaTest {

  @Test
  void maxArea() {
    int[] height = {1,8,6,2,5,4,8,3,7};
    int area = new MaxArea().maxArea2(height);
    System.out.println(area);
    assert 49 == area;
  }

  @Test
  void maxArea2() {
    int[] height = {6,4,3,1,4,6,99,62,1,2,6};
    int area = new MaxArea().maxArea2(height);
    System.out.println(area);
    assert 62 == area;
  }
}
