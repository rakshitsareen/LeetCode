package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	LinkedList<String> res = new LinkedList<String>();
	Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> l : tickets) {
			map.putIfAbsent(l.get(0), new PriorityQueue<String>());
			map.get(l.get(0)).add(l.get(1));
		}
		dfs("JFK");
		return res;
	}

	private void dfs(String departure) {
		PriorityQueue<String> arrivals = map.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		res.addFirst(departure);
	}

}
