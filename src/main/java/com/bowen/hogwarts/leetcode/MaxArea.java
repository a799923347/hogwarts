package com.bowen.hogwarts.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端
 * 点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shachi
 */
public class MaxArea {

  /**
   * 穷举法
   * 执行用时 :262 ms, 在所有 java 提交中击败了27.28%的用户
   * 内存消耗 :40 MB, 在所有 java 提交中击败了92.27%的用户
   */
  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int currentArea = (j - i) * (Math.min(height[i], height[j]));
        max = Math.max(currentArea, max);
      }
    }
    return max;
  }

  /**
   * 首尾指针
   *
   * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。如果我们试图
   * 将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。但是，在同样的条件下，移动指向
   * 较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。因为移动较短线段的指针会得到一条相对较长的线段，
   * 这可以克服由宽度减小而引起的面积减小。
   *
   * 执行用时 :4 ms, 在所有 java 提交中击败了81.73%的用户
   * 内存消耗 :38.7 MB, 在所有 java 提交中击败了94.37%的用户
   */
  public int maxArea2(int[] height) {
    int max = 0;
    int i = 0, j = height.length - 1;
    for (; i < j; ) {
      int currentArea = (j - i) * Math.min(height[i], height[j]);
      max = Math.max(max, currentArea);
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }
}
