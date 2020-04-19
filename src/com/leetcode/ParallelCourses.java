package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {
	public int minimumSemesters(int N, int[][] relations) {
		int[] indegree = new int[N + 1];
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int[] relation : relations) {
			map.putIfAbsent(relation[0], new ArrayList<>());
			map.get(relation[0]).add(relation[1]);
			indegree[relation[1]]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < N + 1; ++i)
			if (indegree[i] == 0)
				q.offer(i);
		int semester = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int c = q.poll();
				N--;
				if (!map.containsKey(c))
					continue;
				for (int i : map.get(c)) {
					if (--indegree[i] == 0)
						q.offer(i);
				}
			}
			++semester;
		}
		return N == 0 ? semester : -1;
	}
}
