package com.david.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode composeNode(ListNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        ListNode head = null;
        for (int i = 0; i < nodes.length; i++) {
            if (i + 1 < nodes.length) {
                nodes[i].next = nodes[i + 1];
            }
        }
        return nodes[0];
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
