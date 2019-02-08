package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {

	private ArrayList<Integer> list;
	private HashMap<Integer, Integer> index;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		this.list = new ArrayList<>();
		this.index = new HashMap<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (index.containsKey(val))
			return false;
		index.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!index.containsKey(val))
			return false;
		int pos = index.get(val);
		if (pos != list.size()) {
			// if it not the last one, swap it with the last one
			int last = list.get(list.size() - 1);
			list.set(pos, last);
			index.put(last, pos);
		}
		list.remove(list.size() - 1);
		index.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
		RandomizedSet sol = new RandomizedSet();
		System.out.println(sol.insert(1));
		System.out.println(sol.remove(2));
		System.out.println(sol.insert(2));
		System.out.println(sol.getRandom());
		System.out.println(sol.remove(1));
		System.out.println(sol.insert(2));
		System.out.println(sol.getRandom());
	}

}
