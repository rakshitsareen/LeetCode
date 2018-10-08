package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null)
			return 0;
		if (s.length() < 1)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		int rightmost = 0;
		int maxlen = 0;
		int start = 0;
		while (rightmost < s.length()) {
			if (map.size() <= 2) {
				map.put(s.charAt(rightmost), rightmost);
				rightmost++;
			}
			if (map.size() > 2) {
				int leftmost = s.length();
				for (int i : map.values())
					leftmost = Math.min(leftmost, i);
				map.remove(s.charAt(leftmost));
				start = leftmost + 1;
			}
			maxlen = Math.max(maxlen, rightmost - start);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		String s = "aabbbc";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

}
