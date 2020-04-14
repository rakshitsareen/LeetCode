package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			int comp = Integer.compare(a[0], b[0]);
			if (comp == 0) {
				if (a[1] == b[1]) {
					return Integer.compare(a[2], b[2]);
				}

				return Integer.compare(a[1], b[1]);
			}

			return comp;
		});
		for (int i = 0; i < workers.length; ++i) {
			int[] worker = workers[i];
			for (int j = 0; j < bikes.length; ++j) {
				int[] bike = bikes[j];
				int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
				pq.add(new int[] { dist, i, j });
			}
		}
		int[] res = new int[workers.length];
		Arrays.fill(res, -1);
		Set<Integer> bikesAssigned = new HashSet<>();
		while (bikesAssigned.size() < workers.length) {
			int[] w = pq.poll();
			if (res[w[1]] == -1 && !bikesAssigned.contains(w[2])) {
				res[w[1]] = w[2];
				bikesAssigned.add(w[2]);
			}
		}
		return res;
	}
}
