package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepChar {
	
	public int lengthOfLongestSubstringWithTemplate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxLen = Integer.MIN_VALUE;
		int begin = 0, end = 0;
		int counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(end < s.length()) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			if(map.get(s.charAt(end)) > 1) counter++;
			end++;
			while(counter > 0) {
				char c = s.charAt(begin);
				if(map.get(c) > 1) counter--;
				map.put(c, map.get(c) - 1);
				begin++;
			}
			maxLen = Math.max(maxLen, end - begin);
		}
		return maxLen;
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxLen = 1;
		int start = 0;
		int end = 0;
		Set<Character> set = new HashSet<>();
		for (end = 0; end < s.length(); end++) {
			if (!set.contains(s.charAt(end))) {
				set.add(s.charAt(end));
			} else {
				maxLen = Math.max(maxLen, end - start);
				while (start < end) {
					if (s.charAt(end) != s.charAt(start)) {
						set.remove(s.charAt(start));
						start++;
					} else {
						break;
					}
				}
				start++;
			}
		}
		maxLen = Math.max(maxLen, end - start);
		return maxLen;
	}

	public static void main(String[] args) {
		
		LongestSubstringWithoutRepChar sol = new LongestSubstringWithoutRepChar();
		System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(sol.lengthOfLongestSubstringWithTemplate("abcabcbb"));
	}
}
