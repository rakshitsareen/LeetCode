package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1 */

public class FirstUniqueCharacterInString {

	public int firstUniqChar(String s) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return s.indexOf(entry.getKey());
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInString sol = new FirstUniqueCharacterInString();
		System.out.println(sol.firstUniqChar("leetcode"));
	}

}
