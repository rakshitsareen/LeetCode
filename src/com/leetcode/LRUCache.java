package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V> {

	static class Node<K,V> {
		K key;
		V val;

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

	int capacity;
	Deque<Node<K, V>> queue = new LinkedList<>();
	Map<K, Node<K, V>> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public V get(K key) {
		if (queue == null || queue.size() == 0 || queue.isEmpty()) {
			return null;
		} else {
			// if the LRU contains the page
			if (map.containsKey(key)) {
				// the page is referenced and we need to move the node in the from of the queue
				Node<K,V> node = map.get(key);
				queue.remove(node);
				map.remove(key);
				queue.addFirst(node); // Node removed and added first.
				map.put(key, node);
				return node.val;
			} else
				return null;
		}
	}

	public void put(K key, V value) {

		Node<K,V> node = new Node<K, V>(key, value); // construct a new node to insert in the list.
		// If cache is full
		if (queue.size() == capacity) {
			if (!map.containsKey(key)) {
				// remove the rear node from the list and add new entries in both cache and map
				Node<K,V> _node = queue.getLast();
				queue.removeLast();
				map.remove(_node.key);
			} else {
				Node<K,V> _node = map.get(key);
				map.remove(_node.key);
				queue.remove(_node);
				// queue.addFirst(node);
				// map.put(key, node);
			}
		} else {
			if (map.containsKey(key)) {
				Node<K,V> _node = map.get(key);
				map.remove(_node.key);
				queue.remove(_node);
			}
		}
		queue.addFirst(node);
		map.put(key, node);
	}

	public static void main(String[] args) {
		LRUCache <Integer, Integer> cache = new LRUCache<Integer, Integer>(2);
		/*
		 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
		 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		 */
		/*
		 * ["LRUCache","get","put","get","put","put","get","get"]
		 * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
		 */
		/*
		 * ["LRUCache","put","put","put","put","get","get"]
		 * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
		 */
		/*
		 * System.out.println(cache.get(2)); cache.put(2, 6);
		 * System.out.println(cache.get(1)); cache.put(1, 5); cache.put(1, 2);
		 * System.out.println(cache.get(1)); System.out.println(cache.get(2));
		 */
		/*
		 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
		 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		 * 
		 */

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
