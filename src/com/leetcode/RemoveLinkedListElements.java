package com.leetcode;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;
		ListNode curr = head, prev = sentinel;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else
				prev = prev.next;
			curr = curr.next;
		}
		return sentinel.next;
	}
}
