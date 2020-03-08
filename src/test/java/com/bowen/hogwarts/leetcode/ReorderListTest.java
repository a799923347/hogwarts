package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReorderListTest {

  @Test
  public void reverseSince() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(2);
    node1.next.next = new ListNode(3);
    node1.next.next.next = new ListNode(4);
    node1.next.next.next.next = new ListNode(5);
    ListNode since = new ReorderList().reverseSince(node1);
    while (since != null) {
      System.out.print(since.val + " -> ");
      since = since.next;
    }
  }

  @Test
  public void reorderList() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(2);
    node1.next.next = new ListNode(3);
    node1.next.next.next = new ListNode(4);
    // node1.next.next.next.next = new ListNode(5);
    new ReorderList().reorderList(node1);
    while (node1 != null) {
      System.out.print(node1.val + " -> ");
      node1 = node1.next;
    }
  }
}