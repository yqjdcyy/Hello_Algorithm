package com.yao.leetcode;

/**
 * @author qingju.yao
 * @date 2020/07/14
 */
public class AddTwoNumbers {

    /**
     * 思路：同步链+ 最后节点可用
     * <p>
     * 解答成功:
     * 执行耗时:2 ms,击败了99.87% 的Java用户
     * 内存消耗:39.7 MB,击败了94.74% 的Java用户
     *
     * @param l1
     * @param l2
     * @return com.yao.leetcode.AddTwoNumbers.ListNode
     * @author qingju.yao
     * @date 2020/7/14
     */
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
