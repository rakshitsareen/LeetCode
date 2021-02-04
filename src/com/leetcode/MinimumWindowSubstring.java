package com.leetcode;

// https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems

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

	// attempt 2 - revise
	public String minWindow2(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for(char c : t.toCharArray())
			map.put(c, map.getOrDefault(c,0) + 1);
		int left = 0, finalLeft = 0, finalRight = 0, minLen = Integer.MAX_VALUE;
		int counter = map.size();
		for(int right = 0; right < s.length(); ++right){
			char c = s.charAt(right);
			if(map.containsKey(c)){
				map.put(c,map.get(c) - 1);
				if(map.get(c) == 0) counter--;
			}
			while(counter == 0){
				if(map.containsKey(s.charAt(left))){
					map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
					if(map.get(s.charAt(left)) > 0) counter++;
				}
				if(right - left + 1 < minLen){
					minLen = right - left + 1;
					finalLeft = left;
					finalRight = right;
				}
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(finalLeft, finalRight + 1);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
		System.out.println(minimumWindowSubstring.minWindow2(s,t));
	}
}