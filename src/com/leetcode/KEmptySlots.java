package com.leetcode;

import java.util.TreeSet;

public class KEmptySlots {

	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> bloomed = new TreeSet<>();
		int day = 0;
		for (int i : flowers) {
			day++;
			bloomed.add(i);
			Integer lo = bloomed.lower(i);
			Integer hi = bloomed.higher(i);
			if (lo != null && i - lo - 1 == k || hi != null && Math.abs(i - hi) - 1 == k)
				return day;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
