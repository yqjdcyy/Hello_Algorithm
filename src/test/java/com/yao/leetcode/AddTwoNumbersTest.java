package com.yao.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddTwoNumbersTest {


    private AddTwoNumbers solution;

    @Before
    public void setUp() throws Exception {
        solution = new AddTwoNumbers();
    }


    @Test
    public void addTwoNumbers() {

        AddTwoNumbers.ListNode result = solution.addTwoNumbers(parseNum2Node(342), parseNum2Node(465));
        Assert.assertEquals(807, parseNode2Num(result));
    }

    @Test
    public void addTwoNumbers2() {

        AddTwoNumbers.ListNode result = solution.addTwoNumbers(parseNum2Node(88_888), parseNum2Node(999));
        Assert.assertEquals(89_887, parseNode2Num(result));
    }

    @Test
    public void addTwoNumbers3() {

        AddTwoNumbers.ListNode result = solution.addTwoNumbers(parseNum2Node(999), parseNum2Node(88_888));
        Assert.assertEquals(89_887, parseNode2Num(result));
    }


    //---------------------------------
    // Test Helper
    //---------------------------------

    @Test
    public void parse() {

        int val = 123;
        Assert.assertEquals(val, parseNode2Num(parseNum2Node(123)));
    }


    public AddTwoNumbers.ListNode parseNum2Node(int val) {

        AddTwoNumbers.ListNode node = null, head = null;
        while (val > 0) {
            if (null == node) {
                node = new AddTwoNumbers.ListNode(val % 10);
                head = node;
            } else {
                node.next = new AddTwoNumbers.ListNode(val % 10);
                node = node.next;
            }
            val /= 10;
        }

        return head;
    }

    public int parseNode2Num(AddTwoNumbers.ListNode node) {

        int val = 0, base = 1;
        while (null != node) {
            val = val + base * node.val;
            base *= 10;
            node = node.next;
        }

        return val;
    }
}