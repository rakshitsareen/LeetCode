package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepChar {

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
	}
}
