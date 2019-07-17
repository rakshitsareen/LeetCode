package com.leetcode;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */

public class NumArray {

	int[] dp;

	public NumArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			dp = null;
			return;
		}
		dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = dp[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if(dp == null) return 0;
		if (i == 0)
			return dp[j];
		if (j >= dp.length)
			return dp[dp.length - 1];
		return dp[j] - dp[i - 1];
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		System.out.println((new NumArray(nums)).sumRange(0, 5));
	}

}
