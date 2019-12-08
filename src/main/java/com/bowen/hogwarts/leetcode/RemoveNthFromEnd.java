package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaobaowen
 */
public class RemoveNthFromEnd {

  /**
   * 遍历一遍链表，遍历过程中将元素保存至额外一个数组中，用空间换时间，实现只使用一趟扫描
   * 空间复杂度O(m)，m为链表的长度
   * 时间复杂度O(m)
   * 执行用时 :1 ms, 在所有 java 提交中击败了55.45%的用户
   * 内存消耗 :35 MB, 在所有 java 提交中击败了86.63%的用户
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    List<ListNode> nodes = new ArrayList<>();
    ListNode pointer = head;
    while (pointer != null) {
      ListNode currentNode = pointer;
      nodes.add(currentNode);
      pointer = pointer.next;
    }
    int removeIndex = nodes.size() - n;
    if (removeIndex == 0) {
      return head.next;
    }
    if (removeIndex == nodes.size() - 1) {
      nodes.get(removeIndex - 1).next = null;
      return head;
    }
    nodes.get(removeIndex - 1).next = nodes.get(removeIndex + 1);
    return head;
  }

}
