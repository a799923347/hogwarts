package com.bowen.hogwarts.leetcode;


import org.junit.jupiter.api.Test;

class TwoNumbersAdditionTest {

  @Test
  public void test() {
    TwoNumbersAddition twoNumbersAddition = new TwoNumbersAddition();
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(6);
    listNode1.next.next = new ListNode(3);
    ListNode listNode2 = new ListNode(3);
    listNode2.next = new ListNode(5);
    ListNode resultNode = twoNumbersAddition.addTwoNumbers(listNode1, listNode2);
    StringBuilder stringBuilder = new StringBuilder();
    while (resultNode != null) {
      stringBuilder.append(resultNode.val);
      resultNode = resultNode.next;
    }
    System.out.print(stringBuilder);
    assert stringBuilder.toString().equals("414");
  }

  @Test
  public void test2() {
    TwoNumbersAddition twoNumbersAddition = new TwoNumbersAddition();
    ListNode listNode1 = new ListNode(5);
    ListNode listNode2 = new ListNode(5);
    ListNode resultNode = twoNumbersAddition.addTwoNumbers(listNode1, listNode2);
    StringBuilder stringBuilder = new StringBuilder();
    while (resultNode != null) {
      stringBuilder.append(resultNode.val);
      resultNode = resultNode.next;
    }
    System.out.print(stringBuilder);
    assert stringBuilder.toString().equals("01");
  }

  /**
   * 输入:
   * [1]
   * [9,9]
   */
  @Test
  public void test3() {
    TwoNumbersAddition twoNumbersAddition = new TwoNumbersAddition();
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(9);
    listNode2.next = new ListNode(9);
    ListNode resultNode = twoNumbersAddition.addTwoNumbers(listNode1, listNode2);
    StringBuilder stringBuilder = new StringBuilder();
    while (resultNode != null) {
      stringBuilder.append(resultNode.val);
      resultNode = resultNode.next;
    }
    System.out.print(stringBuilder);
    assert stringBuilder.toString().equals("001");
  }

}