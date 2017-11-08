package com.leetcode;

public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		boolean flag = false;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				flag = true;
			if (nums[i] > max)
				max = nums[i];
		}
		if (!flag)
			return max;
		int end = 0, sumTillHere = 0, maxSum = Integer.MIN_VALUE;
		while (end < nums.length) {
			sumTillHere += nums[end];
			if (sumTillHere < 0 && !(end == nums.length - 1))
				sumTillHere = 0;
			if (sumTillHere > maxSum) {
				maxSum = sumTillHere;
			}
			end++;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] p = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(MaximumSubarray.maxSubArray(p));
	}

}
