package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		// get the frequency of all the numbers in the array
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		// max heap that will keep the entries sorted based on the frequency
		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		// add the entries from the map into the heap.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(entry);
		}
		// poll out the result from the heap
		while (res.size() < k) {
			Map.Entry<Integer, Integer> val = heap.poll();
			res.add(val.getKey());
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		List<Integer> res = topKFrequent(nums, 2);
		for (int i : res) {
			System.out.println(i);
		}
	}

}
