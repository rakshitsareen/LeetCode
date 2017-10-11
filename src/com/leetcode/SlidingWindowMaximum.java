package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> dq = new ArrayDeque<>();	// deque contains indices of the values
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()])
				dq.removeLast(); // removing indices where element is less than
									// the integer being considered.
			dq.add(i); // adding integral indices to the end, btw, this adds to the tail and not the head.
		}	// till here we have an initial window setup, now we can proceed with the main 
			// algorithm which is just the extension of what we did just now
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




/*
Buttercola Solution


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
         
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
         
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
             
            deque.addLast(i);
             
            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }
             
            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }
         
        return result;
    }
}

*
*/