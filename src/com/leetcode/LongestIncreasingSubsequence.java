package com.leetcode;

public class LongestIncreasingSubsequence {

	public static int lis(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (lis[i] > max)
				max = lis[i];
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("Length of lis is " + lis(arr));
	}
}
