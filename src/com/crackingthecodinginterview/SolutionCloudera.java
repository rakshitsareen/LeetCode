package com.crackingthecodinginterview;

public class SolutionCloudera {
	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int node_value) {
			val = node_value;
			next = null;
		}
	}

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
		if (head == null) {
			head = new LinkedListNode(val);
			tail = head;
		} else {
			tail.next = new LinkedListNode(val);
			tail = tail.next;
		}
		return tail;
	}

	static LinkedListNode removeNodes(LinkedListNode list, int x) {
		if (list == null)
			return list;
		while (list != null && list.val > x)
			list = list.next; // move the head node till it is > x
		LinkedListNode nhead = list;
		LinkedListNode prev = list; // now save the head node;
		list = list.next;
		while (list != null) {
			if (list.val > x) {
				prev.next = list.next;
				list = list.next;
			} else {
				prev = list;
				list = list.next;
			}
		}
		return nhead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
