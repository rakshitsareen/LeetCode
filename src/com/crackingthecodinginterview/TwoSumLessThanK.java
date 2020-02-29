package com.crackingthecodinginterview;

import java.util.Arrays;

public class TwoSumLessThanK {
	public int twoSumLessThanK(int[] A, int K) {
		if (A == null || A.length == 0)
			return -1;
		Arrays.sort(A);
		int lo = 0;
		int n = A.length - 1;
		int hi = n;
		int max = -1;
		while (lo < hi) {
			int sum = A[lo] + A[hi];
			if (sum < K) {
				max = Math.max(max, sum);
				lo++;
			} else {
				hi--;
			}
		}
		return max;
	}
}
