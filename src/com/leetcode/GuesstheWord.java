package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Master {
	public int guess(String word);
}

public class GuesstheWord {
	public void findSecretWord(String[] wordlist, Master master) {
		for (int i = 0; i < 10; ++i) {
			String guess = wordlist[new Random().nextInt(wordlist.length)];
			List<String> list = new ArrayList<String>();
			int x = master.guess(guess);
			if (x == 6)
				return;
			for (String w : wordlist) {
				if (match(guess, w) == x) {
					list.add(w);
				}
			}
			wordlist = list.toArray(new String[list.size()]);
		}
	}

	private int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i)
			if (a.charAt(i) == b.charAt(i))
				matches++;
		return matches;
	}

}
