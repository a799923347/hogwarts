package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeTwoOrderedLinkedListTest {

  @Test
  void mergeTwoLists() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode resultHead = new MergeTwoOrderedLinkedList().mergeTwoLists(l1, l2);
    while (resultHead != null) {
      System.out.println(resultHead.val);
      resultHead = resultHead.next;
    }
  }
}