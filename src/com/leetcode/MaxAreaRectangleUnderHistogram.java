package com.leetcode;

import java.util.Stack;

public class MaxAreaRectangleUnderHistogram {

	public static int largestRectangleArea(int[] heights) {
		// this stack will contain the indices of the histogram
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		int tp = 0;
		int area = 0, max_area = 0;
		int n = heights.length;
		while (i < n) {
			if (s.empty() || heights[i] >= heights[s.peek()]) {
				s.push(i++);
			} else {
				tp = s.peek();
				s.pop();
				area = heights[tp] * (s.empty() ? i : i - s.peek() - 1);
				if (area > max_area) {
					max_area = area;
				}
			}
		}

		while (!s.empty()) {
			tp = s.peek();
			s.pop();
			area = heights[tp] * (s.empty() ? i : i - s.peek() - 1);
			if (area > max_area) {
				max_area = area;
			}
		}
		return max_area;
	}

	public static void main(String[] args) {
		int[] hist = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(MaxAreaRectangleUnderHistogram.largestRectangleArea(hist));
	}
}
