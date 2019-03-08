package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0)
			return "";
		int begin = 0, end = 0;
		int finalbegin = begin, finalend = end;
		int len = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for(Character c : t.toCharArray())
        	map.put(c, map.getOrDefault(c, 0) + 1);
		int counter = map.size();
		while(end < s.length()) {
			if(map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				if(map.get(s.charAt(end)) == 0) counter--;
			}
			end++;
			while(counter == 0) {
				if(map.containsKey(s.charAt(begin))) {
					map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
					if(map.get(s.charAt(begin)) > 0) counter++;
				}
				if(end - begin + 1 < len) {
					len = end - begin + 1;
					finalbegin = begin;
					finalend = end;
				}
				begin++;
			}
		}
		if(len == Integer.MAX_VALUE) return "";
		return s.substring(finalbegin, finalend);
	}

	public static void main(String[] args) {

	}
}