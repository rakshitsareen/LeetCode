package com.leetcode;

public class MinimumSwapsToMakeSequencesIncreasing {
	public int minSwap(int[] A, int[] B) {
		int n = A.length;
		int[] swap = new int[n];
		int[] not_swap = new int[n];
		swap[0] = 1;
		for (int i = 1; i < n; ++i) {
			not_swap[i] = swap[i] = n;
			if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
				swap[i] = swap[i - 1] + 1;
				not_swap[i] = not_swap[i - 1];
			}
			if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
				swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);
				not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
			}
		}
		return Math.min(swap[n - 1], not_swap[n - 1]);
	}
}
