package com.crackingthecodinginterview;

import java.util.HashMap;

public class Problem4 {

	public boolean checkPalindromePerm(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		int count = 0;
		for (char key : map.keySet()) {
			count += map.get(key) % 2;
		}
		return count <= 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem4 sol = new Problem4();
		System.out.println(sol.checkPalindromePerm("tacocat"));
	}

}
