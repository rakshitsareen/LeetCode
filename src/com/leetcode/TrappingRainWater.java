package com.leetcode;

import java.util.Stack;

public class TrappingRainWater {

	// stack based solution
	public static int trap(int[] height) {
		if (null == height || height.length < 3)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(height[0]);
		int i = 0, maxWater = 0, maxBotWater = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
				stack.push(i);
				++i;
			}
			else {
				
			}
		}
		return 0;
	}

	public static void main(String[] args) {

	}

}
