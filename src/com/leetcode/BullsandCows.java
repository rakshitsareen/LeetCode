package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsandCows {

	public Integer bulls(String secret, String guess) {
		int count = 0;
		int i = 0, j = 0;
		while (i < secret.length() && j < guess.length()) {
			if (secret.charAt(i) == guess.charAt(j))
				count++;
			i++;
			j++;
		}
		return count;
	}

	public Integer cows(String secret, String guess) {
		Map<Character, Set<Integer>> m = new HashMap<>();
		int i = 0;
		while (i < secret.length()) {
			if (m.get(secret.charAt(i)) == null) {
				m.put(secret.charAt(i), new HashSet<>());
			}
			m.get(secret.charAt(i)).add(i);
			i++;
		} // hashmap is populated
		i = 0;
		Set<Character> s = new HashSet<>();
		int count = 0;
		while (i < guess.length()) {
			if (m.get(guess.charAt(i)) == null) {
				i++;
				continue;
			}
			if (m.get(guess.charAt(i)).contains(i)) {
				m.get(guess.charAt(i)).remove(i);
				if(m.get(guess.charAt(i)).size() == 0)
					m.remove(guess.charAt(i));
			}
			i++;
		}
		i = 0;
		while (i < guess.length()) {
			s.add(guess.charAt(i));
			i++;
		}
		Set<Character> sc = new HashSet<>(m.keySet());
		for (Character c : sc) {
			if (!s.contains(c))
				m.remove(c);
		}
		for (Set<Integer> si : m.values()) {
			count += si.size();
		}

		return count;
	}

	public String getHint(String secret, String guess) {
		return bulls(secret, guess).toString() + "A" + cows(secret, guess).toString() + "B";
	}

	public static void main(String[] args) {
		System.out.println(new BullsandCows().getHint("11", "10"));
	}

}
