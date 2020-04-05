package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

	public int minTransfers(int[][] transactions) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] t : transactions) {
			map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
			map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
		}
		List<Integer> list = new ArrayList<>();
		for (int i : map.values())
			if (i != 0)
				list.add(i);
		return dfs(0, list);
	}

	private int dfs(int start, List<Integer> list) {
		if (start == list.size())
			return 0;
		int cur = list.get(start);
		if (cur == 0) {
			return dfs(start + 1, list);
		}
		int r = Integer.MAX_VALUE;
		for (int i = start + 1; i < list.size(); ++i) {
			int next = list.get(i);
			if (cur * next < 0) {
				list.set(i, cur + next);
				r = Math.min(r, 1 + dfs(start + 1, list));
				list.set(i, next);
				if (cur + next == 0)
					break;
			}
		}
		return r;
	}

}
