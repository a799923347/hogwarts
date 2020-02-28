package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * (即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行)。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class ZigzagTraverseBinaryTree {

  /**
   * 广度优先搜索的变种，标志位 oddLevel 控制二叉树每层遍历方向，奇数层从左向右遍历，偶数层从右向左遍历
   * 执行用时 :1 ms, 在所有 Java 提交中击败了98.74%的用户
   * 内存消耗 :38 MB, 在所有 Java 提交中击败了5.00%的用户
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> rootLine = new ArrayList<>();
    rootLine.add(root.val);
    result.add(rootLine);
    List<TreeNode> fatherNodes = new ArrayList<>();
    fatherNodes.add(root);
    boolean oddLevel = false;
    for (; ; ) {
      List<Integer> children = new ArrayList<>();
      List<TreeNode> newFather = new ArrayList<>();
      int count = 0;
      if (oddLevel) {
        // 因为偶数层收集的父节点时是从右向左收集的，所以上一层最左边的父节点在list尾部
        for (int i = fatherNodes.size() - 1; i >= 0; i--) {
          if (fatherNodes.get(i).left != null) {
            children.add(fatherNodes.get(i).left.val);
            newFather.add(fatherNodes.get(i).left);
            count++;
          }
          if (fatherNodes.get(i).right != null) {
            children.add(fatherNodes.get(i).right.val);
            newFather.add(fatherNodes.get(i).right);
            count++;
          }
        }
        oddLevel = false;
      } else {
        for (int i = fatherNodes.size() - 1; i >= 0; i--) {
          if (fatherNodes.get(i).right != null) {
            children.add(fatherNodes.get(i).right.val);
            newFather.add(fatherNodes.get(i).right);
            count++;
          }
          if (fatherNodes.get(i).left != null) {
            children.add(fatherNodes.get(i).left.val);
            newFather.add(fatherNodes.get(i).left);
            count++;
          }
        }
        oddLevel = true;
      }
      if (count == 0) {
        break;
      }
      fatherNodes = newFather;
      result.add(children);
    }
    return result;
  }

  /**
   * 官方题解的另一种解法：深度优先搜索
   * 执行用时 :2 ms, 在所有 Java 提交中击败了21.84%的用户
   * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了5.00%的用户
   */
  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> results = new ArrayList<>();
    dfs(root, 0, results);
    return results;
  }

  protected void dfs(TreeNode node, int level, List<List<Integer>> results) {
    if (level >= results.size()) {
      LinkedList<Integer> newLevel = new LinkedList<>();
      newLevel.add(node.val);
      results.add(newLevel);
    } else {
      if (level % 2 == 0) {
        results.get(level).add(node.val);
      } else {
        // add 的时候指明index为0，即在前方插入，这样即可实现这一层的倒序排列
        // tips:此处层数计算从0开始，则偶数层从左向右，奇数层从右向左，与上面自己实现的广度优先搜索层数
        //      从1开始记略有区别
        results.get(level).add(0, node.val);
      }
    }

    if (node.left != null) {
      dfs(node.left, level + 1, results);
    }
    if (node.right != null) {
      dfs(node.right, level + 1, results);
    }
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
