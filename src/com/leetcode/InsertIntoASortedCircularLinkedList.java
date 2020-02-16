package com.leetcode;

public class InsertIntoASortedCircularLinkedList {
	
	public Node insert(Node head, int x) {
		if (head == null) {
			head = new Node(x);
			head.next = head;
			return head;
		}

		Node curr = head.next;
		Node prev = head;
		boolean found = false;
		while (curr != head) {
			int next = curr.val;
			int pre = prev.val;
			if (x == pre || x <= next && x > pre || next < pre && x > pre || next < pre && x < next) {
				found = true;
				Node t = new Node(x);
				prev.next = t;
				t.next = curr;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if (!found) {
			Node t = new Node(x);
			prev.next = t;
			t.next = curr;
		}

		return head;
	}
}
