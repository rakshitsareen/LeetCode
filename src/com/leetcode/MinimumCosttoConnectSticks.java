package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCosttoConnectSticks {

	public static int connectSticks(int[] sticks) {
		if (sticks == null || sticks.length <= 1)
			return 0;
		Queue<Integer> heap = new PriorityQueue<Integer>(
				Arrays.asList(Arrays.stream(sticks).boxed().toArray(Integer[]::new)));
		Integer totalCost = 0;
		while (!heap.isEmpty()) {
			Integer one = heap.poll();
			Integer two = null;
			if (!heap.isEmpty())
				two = heap.poll();
			one = one == null ? 0 : one;
			two = two == null ? 0 : two;
			totalCost += (one + two);
			if(heap.size() == 0) break;
			if (one + two != 0)
				heap.offer(one + two);
		}
		return totalCost;
	}

	public static void main(String[] args) {
		int[] sticks = { /*2, 4, 3 */1,8,3,5};
		System.out.println(connectSticks(sticks));
	}

}
