package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()])
				dq.removeLast(); // removing indices where element is less than
									// the integer being considered.
			dq.add(i); // adding integral indices to the end
		}
		for (int i = k; i < nums.length; i++) {
			result[i - k] = nums[dq.getFirst()];
			while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()])	// remove all elements which are less than the el being considered.
				dq.removeLast();
			while (!dq.isEmpty() && dq.getFirst() <= i - k)	// remove those which are not in current window.
				dq.removeFirst();
			dq.add(i);	// add present el for future consideration.
		}
		result[nums.length - k] = nums[dq.getFirst()]; // why ?
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMaximum sol = new SlidingWindowMaximum();
		nums = sol.maxSlidingWindow(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
