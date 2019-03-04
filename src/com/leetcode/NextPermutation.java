package com.leetcode;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
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

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 4, 7, 5, 3, 2 };
		new NextPermutation().nextPermutation(nums);
		for (int i : nums)
			System.out.print(i);
	}

}
