package com.leetcode;

import java.util.Stack;

public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		;
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode head = null;
		while (!s1.empty() || !s2.empty()) {
			int f = 0, s = 0;
			if (!s1.empty())
				f = s1.pop();
			if (!s2.empty())
				s = s2.pop();
			int t = f + s + carry;
			ListNode temp = new ListNode(t % 10);
			carry = t / 10;
			temp.next = head;
			head = temp;
		}
		if(carry > 0) {
			ListNode temp = new ListNode(carry);
			temp.next = head;
			head = temp;
		}
		return head;
	}

}
