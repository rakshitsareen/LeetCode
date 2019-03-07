package com.leetcode;

public class ValidPalindromeII {

	public boolean isPalidrome(String s) {
		int i = 0, j = s.length() - 1;
		for (; i < j && j > i; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		for (; i <= j && j >= i; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				if (isPalidrome(s.substring(0, j) + s.substring(j + 1, s.length()))
						|| isPalidrome(s.substring(0, i) + s.substring(i + 1, s.length())))
					return true;
				else return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ValidPalindromeII().validPalindrome("abcda"));
	}

}
