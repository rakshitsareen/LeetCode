package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class DisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int k = 1; k <= nums.length; k++) {
			nums[Math.abs(nums[k - 1]) - 1] = nums[Math.abs(nums[k - 1]) - 1] < 0 ? nums[Math.abs(nums[k - 1]) - 1]
					: -nums[Math.abs(nums[k - 1]) - 1];
		}
		List<Integer> repnums = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				repnums.add(i+1);
			}
		}
		return repnums;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		DisappearedNumbers sol = new DisappearedNumbers();
		System.out.println(sol.findDisappearedNumbers(nums));
	}
}
