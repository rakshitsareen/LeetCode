package com.leetcode;

class Node {
	int val;
	Node next;

	public Node() {
		this.val = 0;
		this.next = null;
	}

	public Node(int val) {
		this.val = val;
		this.next = null;
	}

	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

public class ReverseList {

	static Node head = null;

	public static Node reverseUtil(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return head;
		}
		Node next = curr.next;
		curr.next = prev;
		reverseUtil(next, curr);
		return head;
	}

	public static Node reverse(Node curr) {
		if (curr == null)
			return null;
		return reverseUtil(curr, null);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Node ans = ReverseList.reverse(head);
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
