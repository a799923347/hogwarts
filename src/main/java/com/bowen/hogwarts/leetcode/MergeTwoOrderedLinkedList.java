package com.bowen.hogwarts.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class MergeTwoOrderedLinkedList {

  /**
   * 执行用时 :1 ms, 在所有 java 提交中击败了83.91%的用户
   * 内存消耗 :38.5 MB, 在所有 java 提交中击败了71.39%的用户
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode resultHead, assist, currentPointer = new ListNode(0);
    resultHead = assist = currentPointer;
    while (l1 != null || l2 != null) {
      currentPointer = assist;
      int value1 = l1 == null ? Integer.MAX_VALUE : l1.val;
      int value2 = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (value1 < value2) {
        currentPointer.next = new ListNode(value1);
        l1 = l1.next;
      } else {
        currentPointer.next = new ListNode(value2);
        l2 = l2.next;
      }
      assist = currentPointer.next;
    }
    return resultHead.next;
  }

  /**
   * 递归解法
   * 时间复杂度：O(n + m)
   * 空间复杂度：O(n + m)
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    else if (l2 == null) {
      return l1;
    }
    else if (l1.val < l2.val) {
      l1.next = mergeTwoLists2(l1.next, l2);
      return l1;
    }
    else {
      l2.next = mergeTwoLists2(l1, l2.next);
      return l2;
    }

  }
}
