package com.bowen.hogwarts.leetcode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class ReorderList {

  /**
   * 1. 先用快慢指针定位到链表的中间节点
   * 2. 将中间节点后面的链表做反转
   * 3. 将后半部分反转后的单链表拉链式插入到原单链表的前半部分
   *
   * 执行用时 :2 ms, 在所有 Java 提交中击败了82.46%的用户
   * 内存消耗 :44 MB, 在所有 Java 提交中击败了5.12%的用户
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    ListNode slowPointer = head, fastPointer = head;
    // 快慢指针定位中间节点
    // 慢指针步长为1，快指针步长为2
    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    // 反转后半部分的链表
    ListNode localHead = reverseSince(slowPointer.next);

    slowPointer.next = null;
    ListNode pivot = head;
    // 拉链式插入
    while (localHead != null) {
      ListNode next = pivot.next;
      pivot.next = localHead;
      pivot = next;
      ListNode localNext = localHead.next;
      localHead.next = next;
      localHead = localNext;
    }
  }

  /**
   * 反转单链表
   */
  public ListNode reverseSince(ListNode head) {
    ListNode prev = head, pivot = head.next;
    while (pivot != null) {
      ListNode next = pivot.next;
      pivot.next = prev;
      prev = pivot;
      pivot = next;
    }
    head.next = null;
    return prev;
  }

}
