package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

	Map<Integer, Boolean> map;
	boolean[] used;

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (desiredTotal > sum)
			return false;
		if (desiredTotal <= 0)
			return true;
		map = new HashMap<>();
		used = new boolean[maxChoosableInteger + 1];
		return helper(desiredTotal);
	}

	public int format(boolean[] used) {
		int num = 0;
		for (boolean b : used) {
			num <<= 1;
			if (b)
				num |= 1;
		}
		return num;
	}

	public boolean helper(int desiredTotal) {
		if (desiredTotal <= 0)
			return false;
		int key = format(used);
		if (!map.containsKey(key)) {
			for (int i = 0; i < used.length; i++) {
				if (!used[i]) {
					used[i] = true;
					if (helper(desiredTotal - 1)) {
						map.put(key, true);
						used[i] = false;
						return true;
					}
					used[i] = false;
				}
			}
			map.put(key, false);
		}
		return map.get(key);
	}

	public static void main(String[] args) {
		System.out.println(new CanIWin().canIWin(10, 11));
	}

}
