package com.leetcode;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode sentinel = new ListNode(0);
		ListNode result = sentinel;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				sentinel.next = l1;
				sentinel = sentinel.next;
				l1 = l1.next;
			}
			else if (l2.val < l1.val) {
				sentinel.next = l2;
				sentinel = sentinel.next;
				l2 = l2.next;
			} else {
				sentinel.next = l1;
				sentinel = sentinel.next;
				l1 = l1.next;
				sentinel.next = l2;
				sentinel = sentinel.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			sentinel.next = l1;
			sentinel = sentinel.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			sentinel.next = l2;
			sentinel = sentinel.next;
			l2 = l2.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
