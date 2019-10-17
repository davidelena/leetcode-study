package com.david.leetcode;

import org.testng.annotations.Test;

public class OddEvenList {

	@Test
	public void testOddEvenList() {
		ListNode[] listNodes = new ListNode[5];
		for (int i = 0; i < 5; i++) {
			listNodes[i] = new ListNode(i + 1);
		}
		for (int i = 0; i + 1 < listNodes.length; i++) {
			listNodes[i].next = listNodes[i + 1];
		}
		ListNode listNode = oddEvenList(listNodes[0]);
		System.out.println(listNode);
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode oddHead = head;
		ListNode oddPointer = head;
		ListNode evenHead = head.next;
		ListNode evenPointer = evenHead;
		while (evenPointer != null && evenPointer.next != null) {
			oddPointer.next = evenPointer.next;
			oddPointer = oddPointer.next;
			evenPointer.next = oddPointer.next;
			evenPointer = evenPointer.next;
		}
		oddPointer.next = evenHead;
		return oddHead;
	}
}
