package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

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
	
    public int connectSticks2(int[] sticks) {
        int output = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.addAll(Arrays.stream(sticks).boxed().collect(Collectors.toList()));
        while(pq.size() > 1){
            int x = pq.size() > 0 ? pq.poll() : 0;
            int y = pq.size() > 0 ? pq.poll() : 0;
            output += x + y;
            pq.offer(x+y);
        }
        return output;
    }

	public static void main(String[] args) {
		int[] sticks = { /*2, 4, 3 */1,8,3,5};
		System.out.println(connectSticks(sticks));
	}

}
