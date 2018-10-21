package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.util.Pair;

interface Master {
	public int guess(String word);
}

public class GuesstheWord {

	public int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i)
			if (a.charAt(i) == b.charAt(i))
				matches++;
		return matches;
	}

	public void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0, x = 0; i < 10 && x < 6; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			for (String w1 : wordlist)
				for (String w2 : wordlist) {
					if (match(w1, w2) == 0)
						map.put(w1, map.getOrDefault(w1, 0) + 1);
				}
			Pair<String, Integer> minimax = new Pair<String, Integer>("", 1000);
			for (String w : wordlist)
				if (map.getOrDefault(w, 0) < minimax.getValue())
					minimax = new Pair<String, Integer>(w, map.get(w));
			x = master.guess(minimax.getKey());
			List<String> wordlist2 = new ArrayList<>();
			for (String w : wordlist)
				if (match(w, minimax.getKey()) == x)
					wordlist2.add(w);
			wordlist = wordlist2.toArray(new String[0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
