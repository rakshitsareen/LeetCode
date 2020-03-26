package com.crackingthecodinginterview;

public class ProductArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
		if (nums == null)
			return null;
		if (nums.length == 0)
			return nums;
		if (nums.length == 1) {
			if (nums[0] == 1)
				return nums;
			if (nums[0] != 1) {
				int[] ans = { 1 };
				return ans;
			}
		}
		int[] ltor = new int[nums.length];
		int[] rtol = new int[nums.length];
		ltor[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ltor[i] = ltor[i - 1] * nums[i];
		}
		rtol[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			rtol[i] = rtol[i + 1] * nums[i];
		}
		int[] ans = new int[nums.length];
		ans[0] = rtol[1];
		for (int i = 1; i < nums.length - 1; i++) {
			ans[i] = ltor[i - 1] * rtol[i + 1];
		}
		ans[nums.length - 1] = ltor[nums.length - 2];
		return ans;
	}

	public int[] productExceptSelf_revision(int[] nums) {
		int[] lr = new int[nums.length];
		int[] rl = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			lr[i] = i == 0 ? nums[i] : nums[i] * lr[i - 1];
		}
		for (int i = nums.length - 1; i >= 0; --i) {
			rl[i] = i == nums.length - 1 ? nums[nums.length - 1] : nums[i] * rl[i + 1];
		}
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			if (i == 0) {
				output[i] = rl[i + 1];
			} else if (i == nums.length - 1) {
				output[i] = lr[i - 1];
			} else {
				output[i] = lr[i - 1] * rl[i + 1];
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] ans = productExceptSelf(nums);
		for (int i : ans)
			System.out.println(i);
	}

}
