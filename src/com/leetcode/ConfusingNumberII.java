package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int limit;
	static int output = 0;
	static private final int[] nums = { 0, 1, 6, 8, 9 };

	public static int confusingNumberII(int N) {
		map.put(9, 6);
		map.put(8, 8);
		map.put(6, 9);
		map.put(1, 1);
		map.put(0, 0);
		if (N == 1000000000) {
			output++;
			N--;
		}
		limit = N;
		backtrack(0, 0, 1);
		return output;
	}

	private static void backtrack(int num, int rotation, int base) {
		// if (num > limit)
		// return;
		if (num != rotation) {
			output++;
//			System.out.println("num == " + num + " rotation == " + rotation);
		}
		for (int d : nums) {
			if (num == 0 && d == 0 || num > 100000000)
				continue;
			if (num * 10 + d > limit)
				break;
			backtrack(num * 10 + d, map.get(d) * base + rotation, base * 10);
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(confusingNumberII(1000000000));
		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");
	}

}
