package com.leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {

	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int output = 0;
		for (int k = nums.length - 1; k > 1; --k) {
			int i = 0, j = k - 1;
			while (i < j) {
				if (nums[i] + nums[j] > nums[k]) {
					output += j - i;
					j--;
				} else
					i++;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
