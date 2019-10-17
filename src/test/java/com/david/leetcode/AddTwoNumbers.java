package com.david.leetcode;

import java.util.List;

import org.testng.annotations.Test;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * <p>
 * Explanation: 342+465 = 807.
 *
 * @author Administrator
 */
public class AddTwoNumbers {

    @Test
    public void testAddTwoNumbers() {
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l2.next = l4;
        l4.next = l3;

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l44 = new ListNode(4);

        l5.next = l6;
        l6.next = l44;
        System.out.println(addTwoNumbersV2(l2, l5));
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode headNode = null;
        ListNode navNode = null;
        ListNode navNode1 = l1;
        ListNode navNode2 = l2;
        boolean isAdd = false;
        int num1, num2, nodeVal = 0;
        while (l1 != null || l2 != null) {
            num1 = l1 != null ? l1.val : -1;
            num2 = l2 != null ? l2.val : -1;
            nodeVal = num1 + num2;
            if (nodeVal > 9) {
                nodeVal = nodeVal % 10;
                isAdd = true;
            }
            if (headNode == null) {
                headNode = new ListNode(nodeVal);
                navNode = headNode;
                navNode1 = navNode1.next;
                navNode2 = navNode2.next;
            } else {
                if (num1 < 0 && num2 > 0) {
                    navNode.next = new ListNode(num2);
                } else if (num2 < 0 && num1 > 0) {
                    navNode.next = new ListNode(num1);
                } else {
                    navNode.next = new ListNode(isAdd ? nodeVal + 1 : nodeVal);
                }
                navNode = navNode.next;
                navNode1 = navNode1.next;
                navNode2 = navNode.next;
            }
        }
        return headNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long time1 = 1;
        while (l1 != null) {
            num1 += (time1 * l1.val);
            time1 *= 10;
            l1 = l1.next;
        }

        long num2 = 0;
        long time2 = 1;
        while (l2 != null) {
            num2 += (time2 * l2.val);
            time2 *= 10;
            l2 = l2.next;
        }

        long result = num1 + num2;
        if (result == 0) {
            return new ListNode(0);
        }
        ListNode headNode = null;
        ListNode navNode = null;
        while (result > 0) {
            long remainder = result % 10;
            if (headNode == null) {
                headNode = new ListNode((int) remainder);
                navNode = headNode;
            }
            long nextVal = result / 10 % 10;
            result /= 10;
            if (result > 0) {
                navNode.next = new ListNode((int) nextVal);
                navNode = navNode.next;
            }
        }
        return headNode;
    }
}
