package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		backtrack(s, res, new ArrayList<String>());
		return res;
	}

	private boolean isPali(String s) {
		int lo = 0, hi = s.length() - 1;
		while (lo <= hi) {
			if (s.charAt(lo) != s.charAt(hi))
				return false;
			lo++;
			hi--;
		}
		return true;
	}

	private void backtrack(String s, List<List<String>> res, List<String> running) {
		if (s == null || s.length() == 0)
			res.add(new ArrayList<String>(running));
		for (int i = 1; i <= s.length(); ++i) {
			String first = s.substring(0, i);
			String second = s.substring(i);
			if (isPali(first)) {
				if (first != null && first.length() > 0)
					running.add(first);
				backtrack(second, res, running);
				running.remove(running.size() - 1);
			}
		}
	}
	
	private static void printList(List<String> list) {
		System.out.print("[ ");
		for(String s : list) {
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.print(" ]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> res = new PalindromePartitioning().partition(s);
		for(List<String> list : res)
			printList(list);
		
	}

}
