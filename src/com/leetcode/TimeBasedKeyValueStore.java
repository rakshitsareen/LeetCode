package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	Map<String, TreeMap<Integer, String>> map;

	/** Initialize your data structure here. */
	public TimeBasedKeyValueStore() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		map.putIfAbsent(key, new TreeMap<>());
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> tmap = map.get(key);
		if (tmap == null)
			return "";
		Integer floor = tmap.floorKey(timestamp);
		if (floor == null)
			return "";
		return tmap.get(floor);
	}
}
