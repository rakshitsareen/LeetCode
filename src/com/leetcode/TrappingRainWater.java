package com.leetcode;

import java.util.Stack;

public class TrappingRainWater {

	public static int trap(int[] A) {
		int left = 0, right = A.length - 1;
		int maxleft = 0, maxright = 0;
		int res = 0;
		while (left <= right) {
			if (A[left] <= A[right]) {
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;
	}

	public static int trap_Stack_Version(int[] height){
		Stack<Integer> stack = new Stack<>();
		int output = 0, current = 0;
		while(current < height.length){
			while(!stack.isEmpty() && height[current] > height[stack.peek()]){
				int top = stack.pop();
				if(stack.isEmpty()) break;
				int distance = current - stack.peek() - 1;
				int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
				output += boundedHeight * distance;
			}
			stack.push(current++);
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 1, 2, 3, 4, 5 }));
	}

}
