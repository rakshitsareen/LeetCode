package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctChars {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() < 3)
			return s.length();
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end;
		int len = 0;
		int numDistinct = 0;
		for (end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			/*
			 * here you might be adding new elements in the window, so remove previous ones
			 * from the window and shrink the window
			 */
			if (map.get(c) == null) {
				map.put(c, 1);
				numDistinct++;
				// now shrink window if start does not crosses end and till numDistint doesn't come to 2
				while (start < end && numDistinct > 2) {
					if (map.get(s.charAt(start)) == 1)
						map.remove(s.charAt(start));
					else
						map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
					if (!map.containsKey(s.charAt(start)))
						numDistinct--;
					start++;
				}
			} else {
				map.put(s.charAt(start), map.get(s.charAt(start)) + 1); // increase
																		// the
																		// frequency
			}
			len = Math.max(len, end - start + 1);
		}
		return len;

	}

	public static void main(String[] args) {
		LongestSubstringWithAtmostTwoDistinctChars sol = new LongestSubstringWithAtmostTwoDistinctChars();
		String s = "eceba";
		System.out.println(sol.lengthOfLongestSubstring(s));
	}
}
