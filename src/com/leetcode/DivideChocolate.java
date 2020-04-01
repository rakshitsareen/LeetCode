package com.leetcode;

public class DivideChocolate {
	public int maximizeSweetness(int[] sweetness, int K) {
		int min = Integer.MAX_VALUE, sum = 0;
		for (int n : sweetness) {
			min = Math.min(min, n);
			sum += n;
		}
		// System.out.println(sum);
		int lo = min, hi = sum;
		while (lo < hi) {
			int mid = (lo + hi + 1) / 2;
			// System.out.println("lo ::" + lo + " hi ::" + hi + " mid :: " + mid);
			int peices = 0;
			int tillnow = 0;
			for (int n : sweetness) {
				tillnow += n;
				if (tillnow >= mid) {
					tillnow = 0;
					peices++;
				}
				// else
				// tillnow += n;
			}
			if (peices >= K + 1)
				lo = mid;
			else
				hi = mid - 1;
		}
		return lo;
	}

}
