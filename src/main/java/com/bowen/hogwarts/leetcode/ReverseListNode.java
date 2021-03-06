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

  /**
   * 对比上面的实现，官方的更简洁
   */
  public ListNode reverseList3(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  /**
   * 递归解法
   * 利用递归时虚拟机栈的入栈出栈，实现链表指针的后退
   *
   * 时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
   * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
   *
   */
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList2(head.next);
    // 以链表末尾的元素为例
    // 通过这一行代码将下一个节点的next指针指向自己(即head)
    //                   head            p
    //    +------+      +------+ <--- +------+
    // ...|      | ---> |      | ---> |      |
    //    +------+      +------+      +------+
    head.next.next = head;

    // 断开原本指向next的指针
    //                   head            p
    //    +------+      +------+      +------+
    // ...|      | ---> |      | <--- |      |
    //    +------+      +------+      +------+
    head.next = null;

    // p指针指向链表最后一个元素，即反转后链表的头指针，每层递归透传p指针，递归过程中不会修改p的指向
    return p;
  }

}
