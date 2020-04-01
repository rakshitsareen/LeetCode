package com.leetcode;

public class CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int D) {
		int max = 0, sum = 0;
		for (int w : weights) {
			max = Math.max(max, w);
			sum += w;
		}
		int lo = max, hi = sum;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int days = 1;
			int wght = 0;
			for (int n : weights) {
				if (wght + n > mid) {
					wght = n;
					days++;
				} else {
					wght += n;
				}
			}
			if (days > D)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
}
