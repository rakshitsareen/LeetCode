package com.leetcode;

import com.leetcode.ListNode;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode c1 = l1;
		ListNode c2 = l2;
		// we will return the next of this sentinel after forming the answer
		ListNode marker = new ListNode(0);
		ListNode ans = marker;
		int sum = 0;
		while (c1 != null && c2 != null) {
			// take out the carry from the previous computation
			sum /= 10;
			// now sum contains the carry
			sum += c1.val;
			sum += c2.val;
			c1 = c1.next;
			c2 = c2.next;
			ans.next = new ListNode(sum % 10);
			ans = ans.next;
		}
		while (c1 != null) {
			sum /= 10;
			sum += c1.val;
			c1 = c1.next;
			ans.next = new ListNode(sum % 10);
			ans = ans.next;
		}
		while (c2 != null) {
			sum /= 10;
			sum += c2.val;
			c2 = c2.next;
			ans.next = new ListNode(sum % 10);
			ans = ans.next;
		}
		int carry = sum / 10;
		if (sum > 10) {
			ans.next = new ListNode(sum % 10);
			sum /= 10;
		}
		if (carry > 0) {
			ans.next = new ListNode(carry);
		}
		return marker.next;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(6);

		ListNode head2 = new ListNode(0);
		// head2.next = new ListNode(2);
		// head2.next.next = new ListNode(1);
		ListNode head = addTwoNumbers(head1, head2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}
