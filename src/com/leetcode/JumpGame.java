package com.leetcode;

public class JumpGame {

	// TLE problem
	public boolean canJumpUtil(int[] nums, int start, int end) {
		if (start == end)
			return true;
		// if (start > end)
		// return false;
		for (int jump = nums[start]; jump > 0; jump--) {
			// check if this jump can do it.
			if (canJumpUtil(nums, start + jump, end))
				return true;
		}
		return false;
	}

	// TLE problem
	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return true;
		boolean allzero = true;
		boolean no_zero_at_all = true;
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0)
				allzero = false;
		}
		if (allzero)
			return false;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0)
				no_zero_at_all = false;
		}
		if (no_zero_at_all)
			return true;
		// there is at least one zero in the array.
		return canJumpUtil(nums, 0, len - 1);
	}

	public boolean canJump2(int[] nums) {
		int i = 0;
		for (int reach = 0; i < nums.length && i <= reach; i++) {
			reach = Math.max(i + nums[i], reach);
		}
		return i == nums.length;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		JumpGame sol = new JumpGame();
		System.out.println(sol.canJump(nums));
	}

}
