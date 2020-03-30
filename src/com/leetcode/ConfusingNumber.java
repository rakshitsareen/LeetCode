package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {
	public boolean confusingNumber(int N) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(9, 6);
		map.put(8, 8);
		map.put(6, 9);
		map.put(1, 1);
		map.put(0, 0);
		int x = N;
		int revnum = 0;
		while (x != 0) {
			int remainder = x % 10;
			int quotient = x / 10;
			if (!map.containsKey(remainder))
				return false;
			revnum = revnum * 10 + map.get(remainder);
			x = quotient;
		}
		return revnum != N;
	}
}
