package com.leetcode;

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i])
			i--;
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i])
				j--;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		for (int k = i + 1, j = nums.length - 1; k < nums.length && j > k; k++, j--) {
			int temp = nums[k];
			nums[k] = nums[j];
			nums[j] = temp;
		}
	}

	public static void nextPermutationAgain(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i])
				j--;
			swap(nums, i, j);
		}
		reverse(nums, i + 1, nums.length - 1);
	}

	public static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void reverse(int[] A, int i, int j) {
		while (i < j)
			swap(A, i++, j--);
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 4, 7, 5, 3, 2 };
		nextPermutationAgain(nums);
		for (int i : nums)
			System.out.print(i);
	}

}
