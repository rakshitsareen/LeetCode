package com.leetcode;

public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = reverse(slow.next);
		slow.next = null;

		while (head != null && head2 != null) {
			ListNode tmp1 = head.next;
			ListNode tmp2 = head2.next;
			head2.next = head.next;
			head.next = head2;
			head = tmp1;
			head2 = tmp2;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}

}
