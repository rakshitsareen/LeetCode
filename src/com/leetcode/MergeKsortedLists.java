package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "" + val;
	}

}

class ListNodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode arg0, ListNode arg1) {
		if (arg0.val < arg1.val)
			return -1;
		else if (arg0.val > arg1.val)
			return 1;
		else
			return 0;
	}
}

public class MergeKsortedLists {
	Comparator<ListNode> comparator = new ListNodeComparator();
	Queue<ListNode> pqueue = new PriorityQueue<>(comparator);
	ListNode finalList;

	public ListNode mergeKLists(ListNode[] lists) {
		/*
		 * Algorithm: Insert each lists' head into the heap (pqueue) remove one
		 * and insert it in final list. move the selected min node forward.
		 * repeat until all lists are exhausted.
		 */

		ListNode head = null;

		if (lists != null)
			initializeHeap(lists, pqueue);
		if (lists != null) {
			while (!pqueue.isEmpty()) { // till there are some nodes to process
				ListNode minNode = pqueue.remove();
				if (finalList == null) {
					finalList = minNode;
					head = finalList;
				} else {
					finalList.next = minNode;
					finalList = finalList.next;
				}
				minNode = minNode.next; // update the list whose head we have just extracted
				if (minNode != null) {
					pqueue.add(minNode); // add the next node in the heap.
				}
			}
		}
		return head;
	}

	public void initializeHeap(ListNode[] lists, Queue<ListNode> pqueue) {
		int numberOfLists = lists.length;
		// build heap from first nodes of each list.
		if (lists != null) {
			for (int i = 0; i < numberOfLists; i++) {
				if (null != lists[i]) { // as pqueue doesn't allow null entries.
					pqueue.add(lists[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(6);
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(5);
		ListNode list3 = new ListNode(10);
		list3.next = new ListNode(-11);
		list3.next.next = new ListNode(100);
		ListNode[] lists = { list1, list2, list3 };
		MergeKsortedLists solution = new MergeKsortedLists();
		ListNode head = solution.mergeKLists(lists);
		while (head != null) {
			System.out.println(head);
			head = head.next;
		}
	}
}
