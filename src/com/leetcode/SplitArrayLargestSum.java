package com.leetcode;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		int sum = 0, max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}
		if (m == 1)
			return sum;
		int lo = max, hi = sum;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int k = pieces(nums, mid);
			if (k > m)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	private int pieces(int[] nums, int target) {
		int k = 1;
		int sumtillnow = 0;
		for (int num : nums) {
			if (sumtillnow + num > target) {
				sumtillnow = num;
				k++;
			} else {
				sumtillnow += num;
			}
		}
		return k;
	}
}
