package com.bowen.hogwarts.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class ReverseListNode {

  /**
   * 使用单独的空间保存当前指针指向的元素的前后元素，反转当前指针元素的next的指向
   *
   * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
   * 内存消耗 :37.2 MB, 在所有 java 提交中击败了31.71%的用户
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = head, pointer = head, next = head;
    while (next != null) {
      next = pointer.next;
      if (pointer == head) {
        pointer.next = null;
      } else {
        pointer.next = prev;
      }
      prev = pointer;
      pointer = next;
    }
    return prev;
  }

}
