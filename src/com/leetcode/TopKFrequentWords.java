package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);
		PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<Map.Entry<String, Integer>>((a,
				b) -> (a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			heap.offer(entry);
			if (heap.size() > k)
				heap.poll();
		}
		while (!heap.isEmpty())
			res.add(0, heap.poll().getKey());
		return res;
	}

}
