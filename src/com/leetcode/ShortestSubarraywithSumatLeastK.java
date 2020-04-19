package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastK {
	public int shortestSubarray(int[] A, int K) {
		int n = A.length;
		int ans = n + 1;
		int[] B = new int[n + 1];
		// B[0] = A[0];
		for (int i = 0; i < n; ++i) {
			B[i + 1] = B[i] + A[i];
		}
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n + 1; ++i) {
			while (dq.size() > 0 && B[i] - B[dq.getFirst()] >= K) {
				ans = Math.min(ans, i - dq.pollFirst());
			}
			while (dq.size() > 0 && B[i] <= B[dq.getLast()])
				dq.pollLast();
			dq.addLast(i);
		}
		return ans <= n ? ans : -1;
	}
}
