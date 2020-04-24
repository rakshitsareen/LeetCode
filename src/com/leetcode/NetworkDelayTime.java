package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] time : times) {
			map.putIfAbsent(time[0], new HashMap<>());
			map.get(time[0]).put(time[1], time[2]);
		}
		Set<Integer> visited = new HashSet<>();
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.offer(new int[] { 0, K });
		int res = 0;
		while (!pq.isEmpty()) {
			int[] n = pq.poll();
			if (visited.contains(n[1]))
				continue;
			visited.add(n[1]);
			res = n[0];
			N--;
			if (!map.containsKey(n[1]))
				continue;
			for (int neighbor : map.get(n[1]).keySet()) {
				if (visited.contains(neighbor))
					continue;
				pq.offer(new int[] { n[0] + map.get(n[1]).get(neighbor), neighbor });
			}
		}
		return N == 0 ? res : -1;
	}
}
