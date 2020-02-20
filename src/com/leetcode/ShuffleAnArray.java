package com.leetcode;

public class ShuffleAnArray {

	java.util.Random rand;
	int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
		rand = new java.util.Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null) return null;
		int[] a = nums.clone();
		for (int j = 1; j < a.length; ++j) {
			int r = rand.nextInt(j + 1);
			swap(a, r, j);
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
