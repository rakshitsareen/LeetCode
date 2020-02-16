package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		helper(res, "", 0, 0, n);
		return res;
	}

	private static void helper(List<String> res, String str, int open, int close, int max) {
		if (str.length() == max * 2) {
			res.add(str);
			return;
		}
		if (open < max)
			helper(res, str + "(", open + 1, close, max);
		if (close < open)
			helper(res, str + ")", open, close + 1, max);
	}

	private static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		generateParenthesis(3).forEach(string -> print(string));
	}

}
