package com.leetcode;

import java.util.Random;

public class RandomPickwithWeight {
	int[] w;
	Random rand;

	public RandomPickwithWeight(int[] w) {
		this.w = w;
		for (int i = 1; i < w.length; ++i) {
			w[i] += w[i - 1];
		}
		rand = new Random();
	}

	public int pickIndex() {
		int len = w.length;
		int idx = rand.nextInt(w[len - 1]) + 1;
		int lo = 0, hi = len - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (w[mid] == idx)
				return mid;
			if (w[mid] < idx)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
}
