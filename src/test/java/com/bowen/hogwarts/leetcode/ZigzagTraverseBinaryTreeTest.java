package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import com.alibaba.fastjson.JSON;
import java.util.List;
import org.junit.Test;

public class ZigzagTraverseBinaryTreeTest {

  @Test
  public void zigzagLevelOrder() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> lists = new ZigzagTraverseBinaryTree().zigzagLevelOrder2(root);
    System.out.println(JSON.toJSONString(lists));
  }
}