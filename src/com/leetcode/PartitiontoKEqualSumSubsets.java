package com.leetcode;

// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {

	public boolean search(int[] groups, int row, int[] nums, int target) {
		if (row < 0)
			return true;
		int v = nums[row--];
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] + v <= target) {
				groups[i] += v;
				if (search(groups, row, nums, target))
					return true;
				groups[i] -= v;
			}

			//if (groups[i] == 0)
			//	break;
		}
		return false;
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int target = sum / k;
		Arrays.sort(nums);
		int row = nums.length - 1;
		if (nums[row] > target)
			return false;
		while (row >= 0 && nums[row] == target) {
			k--;
			row--;
		}
		return search(new int[k], row, nums, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
