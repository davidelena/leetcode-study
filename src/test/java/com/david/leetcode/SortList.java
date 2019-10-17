package com.david.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortList {

    @Test
    public void testSortList() {
        ListNode testNode = getTestDataNode2();
        System.out.println(testNode);
        quickSort(testNode, null);
//        ListNode node = sortList(testNode);
        System.out.println(testNode);

    }

    public ListNode getTestDataNode() {
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        return node;
    }

    public ListNode getTestDataNode2() {
        ListNode node = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return node;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // This is an index node to trace the end of the sorted node.
        ListNode loopNode = head;
        ListNode headPointer = head;
        while (loopNode.next != null) {
            ListNode pointer = loopNode.next;
            while (pointer != null) {
                // If the previous node value is larger than the behind node, change the value
                if (loopNode.val > pointer.val) {
                    swap(loopNode, pointer);
                }
                // move to the next node
                pointer = pointer.next;
            }
            // move the loop index node to the next
            loopNode = loopNode.next;

        }
        return headPointer;
    }

    private void quickSort(ListNode head, ListNode tail){
        if (head == tail){
            return;
        }
        ListNode slow = head, fast = head.next;
        int p = head.val;
        while (fast != tail){
            if (fast.val <= p){
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, tail);
    }

    /**
     * swap the node value
     *
     * @param node1
     * @param node2
     */
    public void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
