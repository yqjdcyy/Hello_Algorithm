package com.yao.leetcode.leetcode.editor.cn;
// 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
// 示例：
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
// 输出：7 -> 0 -> 8
// 原因：342 + 465 = 807
// 
// Related Topics 链表 数学
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 */
class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        int up = 0;
        for (int v1 = 0, v2 = 0, val = 0;
             null != l1 || null != l2;
             l1 = null == l1 ? null : l1.next,
                     l2 = null == l2 ? null : l2.next) {

            v1 = null == l1 ? 0 : l1.val;
            v2 = null == l2 ? 0 : l2.val;
            val = v1 + v2 + up;
            up = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
        }

        if (0 != up) {
            current.next = new ListNode(up);
        }


        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}