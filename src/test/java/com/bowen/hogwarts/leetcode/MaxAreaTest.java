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
    int area = new MaxArea().maxArea(height);
    System.out.println(area);
    assert 49 == area;
  }
}
