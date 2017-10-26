package com.crackingthecodinginterview;

import java.util.HashMap;
import java.util.Map;

public class PairSumK {

	static int countPairs(int k, int[] a) {
		int n = a.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!hm.containsKey(a[i]))
				hm.put(a[i], 0);
			hm.put(a[i], hm.get(a[i]) + 1);
		}
		int twice_count = 0;
		for (int i = 0; i < n; i++) {
			if (hm.get(k - a[i]) != null)
				twice_count += hm.get(k - a[i]);
			if (k - a[i] == a[i])
				twice_count--;
		}
		return twice_count / 2;
	}

	public static void main(String[] args) {

	}

}
