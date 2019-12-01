package com.bowen.hogwarts.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumbersAddition {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode currentNode1 = l1;
    ListNode currentNode2 = l2;
    ListNode nextNode1;
    ListNode nextNode2;
    ListNode resultHead, resultCurrentNode = new ListNode(-1), resultNextNode = null;
    resultHead = resultCurrentNode;
    int assist = -1;
    do {
      nextNode1 = currentNode1.next;
      nextNode2 = currentNode2.next;
      int sum = currentNode1.val + currentNode2.val + (assist >= 0 ? 1 : 0);
      assist = sum - 10;
      if (resultNextNode != null) {
        resultCurrentNode = resultNextNode;
      }
      resultCurrentNode.val = assist >= 0 ? assist : sum;
      resultCurrentNode.next = resultNextNode = new ListNode(0);
      currentNode1 = nextNode1;
      currentNode2 = nextNode2;
    } while (currentNode1 != null && currentNode2 != null);
    if (nextNode1 == null) {
      resultCurrentNode.next = nextNode2;
    }
    if (nextNode2 == null) {
      resultCurrentNode.next = nextNode1;
    }
    if (assist >= 0) {
      if (resultCurrentNode.next == null) {
        resultCurrentNode.next = new ListNode(1);
      } else {
        do {
          resultNextNode = resultCurrentNode.next;
          if (resultCurrentNode.next == null) {
            resultCurrentNode.next = new ListNode(0);
          }
          int sum = resultCurrentNode.next.val + 1;
          assist = sum - 10;
          resultCurrentNode.next.val = assist >= 0 ? assist : sum;
          resultCurrentNode = resultNextNode;
        } while (assist >= 0);
      }
    }
    return resultHead;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
