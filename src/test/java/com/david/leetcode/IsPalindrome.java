package com.david.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Issue 234
 * Topic: LinkedList, Two Pointers
 * <p>
 * Input: 1->2
 * Output: false
 * <p>
 * Input: 1->2->2->1
 * Output: true
 */
public class IsPalindrome {

    @Test
    public void testIsPalindrome() {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[1] = new ListNode(2);
        listNodes[2] = new ListNode(1);
        ListNode head = ListNode.composeNode(listNodes);
        System.out.println(head);
        assertTrue(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean result = true;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode navNode = head;
        ListNode checkNode = head;
        do {
            stack.push(navNode.val);
            navNode = navNode.next;
        } while (navNode != null);

        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (checkNode == null)
                return false;
            int checkVal = checkNode.val;
            checkNode = checkNode.next;
            if (val != checkVal) {
                return false;
            }
        }

        return result;
    }
}
