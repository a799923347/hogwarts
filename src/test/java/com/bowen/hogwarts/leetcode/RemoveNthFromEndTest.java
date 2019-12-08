package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveNthFromEndTest {

  @Test
  void removeNthFromEnd() {
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(2);
    listNode1.next.next = new ListNode(3);
    listNode1.next.next.next = new ListNode(4);
    listNode1.next.next.next.next = new ListNode(5);
    ListNode head = new RemoveNthFromEnd().removeNthFromEnd(listNode1, 2);
    for (ListNode pointer = head; pointer != null; pointer = pointer.next) {
      System.out.println(pointer.val);
    }
  }

  @Test
  void removeNthFromEnd2() {
    ListNode listNode = new ListNode(1);
    ListNode head = new RemoveNthFromEnd().removeNthFromEnd(listNode, 1);
    for (ListNode pointer = head; pointer != null; pointer = pointer.next) {
      System.out.println(pointer.val);
    }
  }

  @Test
  void removeNthFromEnd3() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    ListNode head = new RemoveNthFromEnd().removeNthFromEnd(listNode, 1);
    for (ListNode pointer = head; pointer != null; pointer = pointer.next) {
      System.out.println(pointer.val);
    }
  }
}