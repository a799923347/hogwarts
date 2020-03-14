package com.bowen.hogwarts.leetcode;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由
 * 四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二
 * 维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0]
 * ,[0,0,0,0,0,0,0,1,1,1,0,0,0]
 * ,[0,1,1,0,1,0,0,0,0,0,0,0,0]
 * ,[0,1,0,0,1,1,0,0,1,0,1,0,0]
 * ,[0,1,0,0,1,1,0,0,1,1,1,0,0]
 * ,[0,0,0,0,0,0,0,0,0,0,1,0,0]
 * ,[0,0,0,0,0,0,0,1,1,1,0,0,0]
 * ,[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class MaxAreaOfIsland {

  private int localArea, width, height;
  private int maxArea = Integer.MIN_VALUE;

  /**
   * 如果数组中 cell 中的值为 1，则向该 cell 的四周递归计算岛屿的延伸，cell 中的值
   * 为 0 则跳过该 cell，递归过程中搜索过的 cell 将其置为 0，防止后续过程中重复遍历，
   * 减少不必要的重复计算。
   *
   * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
   * 内存消耗 :41.1 MB, 在所有 Java 提交中击败了91.48%的用户
   */
  public int maxAreaOfIsland(int[][] grid) {
    height = grid.length;
    width = grid[0].length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        localArea = 0;
        findMax(grid, i, j);
        if (localArea > maxArea) {
          maxArea = localArea;
        }
      }
    }
    return maxArea;

  }

  private void findMax(int[][] grid, int i, int j) {
    if (i >= height || i < 0 || j >= width || j < 0 || grid[i][j] == 0) {
      return;
    }
    grid[i][j] = 0;
    localArea++;
    findMax(grid, i + 1, j);
    findMax(grid, i, j + 1);
    findMax(grid, i - 1, j);
    findMax(grid, i, j - 1);
  }

}
