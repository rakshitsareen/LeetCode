package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode save = head;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode x = new RandomListNode(head.label);
		map.put(head, x);
		RandomListNode save_x = x;
		while (head.next != null) {
			x.next = new RandomListNode(head.next.label);
			map.put(head.next, x.next);
			x = x.next;
			head = head.next;
		}
		head = save;
		x = save_x;
		while (head != null) {
			x.random = map.get(head.random);
			head = head.next;
			x = x.next;
		}
		return save_x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
