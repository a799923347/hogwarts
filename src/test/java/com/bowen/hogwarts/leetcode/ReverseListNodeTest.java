package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseListNodeTest {

  @Test
  void reverseList() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode resultPointer = new ReverseListNode().reverseList2(head);
    while (resultPointer != null) {
      System.out.print(resultPointer.val + "->");
      resultPointer = resultPointer.next;
    }
  }
}