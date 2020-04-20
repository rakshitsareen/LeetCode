package com.leetcode;

import java.util.TreeMap;

public class MyCalendarI {
	TreeMap<Integer, Integer> calendar;

	public MyCalendarI() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer floor = calendar.floorKey(start);
		if (floor != null && calendar.get(floor) > start)
			return false;
		Integer ceiling = calendar.ceilingKey(start);
		if (ceiling != null && ceiling < end)
			return false;
		calendar.put(start, end);
		return true;
	}
}
