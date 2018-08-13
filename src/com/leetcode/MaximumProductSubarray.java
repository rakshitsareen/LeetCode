package com.leetcode;

public class MaximumProductSubarray {

	public int maxProduct2(int[] nums, int n) {
		int r = nums[0];

		for (int i = 1, imax = r, imin = r; i < n; i++) {
			// we swap this because if we multiply with a negative number
			// min becomes max, max becomes min, so swap
			if (nums[i] < 0) {
				int temp = imin;
				imin = imax;
				imax = temp;
			}
			// here we figure out whether we need to start a new maxproduct
			// or continue with the old one.
			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);

			// now check this new max with the newly calculated max
			r = Math.max(imax, r);
		}
		return r;
	}

	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		// int[] arr = { -4, 0, 1, 2, 3, 4, 5, -10, 3, 2, 5, 0, 0, 0 };
		int[] prr = { -2, 0, -1 };
		System.out.println(obj.maxProduct2(prr, prr.length));
	}
}