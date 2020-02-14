package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

	List<Integer> list;
	Map<Integer, Integer> idx;
	Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomO1() {
		list = new ArrayList<Integer>();
		idx = new HashMap<Integer, Integer>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (idx.containsKey(val))
			return false;
		idx.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!idx.containsKey(val))
			return false;
		int pos = idx.get(val);
		if (pos != list.size()) {
			int last = list.get(list.size() - 1);
			list.set(pos, last);
			idx.put(last, pos);
		}
		list.remove(list.size() - 1);
		idx.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
	}

}
