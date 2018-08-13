package com.leetcode;

public class MaximumProductSubarray {

	public int maxProduct(int nums[]) {
		if (nums != null && nums.length == 1) {
			return nums[0];
		}l
		boolean allzeros = true;
		// check if all are zeros, then return 0
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] != 0)
				allzeros = false;
		}
		if (allzeros) {
			return 0;
		}
		int maxendinghere = 1;
		int minendinghere = 1;
		int maxsofar = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				maxendinghere = maxendinghere * nums[i];
				minendinghere = Math.min(minendinghere * nums[i], 1);
			} else if (nums[i] == 0) {
				maxendinghere = 1;
				minendinghere = 1;
			} else {
				int temp = maxendinghere;
				maxendinghere = Math.max(minendinghere * nums[i], 1);
				minendinghere = temp * nums[i];
			}

			if (maxsofar < maxendinghere) {
				maxsofar = maxendinghere;
			}
		}

		return maxsofar;
	}

	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		// int[] arr = { -4, 0, 1, 2, 3, 4, 5, -10, 3, 2, 5, 0, 0, 0 };
		int[] arr = { -2, 0, -1 };
		// int[] arr = { 2, 3, -2, 4 };
		System.out.println(obj.maxProduct(arr));
	}
}