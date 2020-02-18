package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	
    public int[] nextGreaterElements(int[] nums) {
    	int[] next = new int[nums.length];
    	Stack<Integer> stack = new Stack<Integer>();
    	Arrays.fill(nums, -1);
    	int n = nums.length;
    	for(int i = 0; i< 2*n; ++i) {
    		int num = nums[i % n];
    		while(!stack.isEmpty() && nums[stack.peek()] < num)
    			next[stack.pop()] = num;
    		if(i < n) stack.push(i);
    	}
    	return next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
