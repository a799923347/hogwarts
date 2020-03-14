package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxAreaOfIslandTest {

  @Test
  public void maxAreaOfIsland() {
    int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    int i = new MaxAreaOfIsland().maxAreaOfIsland(grid);
    System.out.println("最大面积：" + i);
    assert i == 6;
  }

  @Test
  public void maxAreaOfIsland2() {
    int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};
    int i = new MaxAreaOfIsland().maxAreaOfIsland(grid);
    System.out.println("最大面积：" + i);
    assert i == 0;


  }
}