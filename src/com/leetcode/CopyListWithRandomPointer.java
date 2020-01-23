package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class _Node {
	int val;
	_Node next, random;

	_Node(int x) {
		this.val = x;
	}
};

public class CopyListWithRandomPointer {

	public _Node copyRandomList(_Node head) {
		if (null == head)
			return null;
		Map<_Node, _Node> map = new HashMap<_Node, _Node>();
		_Node temp = head;
		_Node newNode = null;
		while (temp != null) {
			newNode = new _Node(temp.val);
			map.put(temp, newNode);
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			map.get(temp).next = map.get(temp.next);
			map.get(temp).random = map.get(temp.random);
			temp = temp.next;
		}
		return map.getOrDefault(head, null);
	}

	public static void main(String[] args) {

	}
}
