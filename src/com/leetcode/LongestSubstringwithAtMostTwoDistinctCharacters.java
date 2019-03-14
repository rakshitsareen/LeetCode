package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	
	public static int lengthOfLongestSubstringTwoDistinctWithTemplate(String s) {
		int maxLen = Integer.MIN_VALUE;
		if(s == null || s.length() == 0) return 0;
		Map<Character, Integer > map = new HashMap<>();
		int begin = 0, end = 0;
		int counter = 0;
		while(end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(map.get(c) == 1) counter++;	// new character added
			end++;
			while(counter > 2) {
				char temp = s.charAt(begin);
				map.put(temp, map.get(temp) - 1);
				if(map.get(temp) == 0) counter--;
				begin++;
			}
			maxLen = Math.max(maxLen, end- begin);
		}
		return maxLen;
	}

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
