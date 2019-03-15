package com.leetcode;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.isEmpty())
			return true;
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			if (!Character.isLetter(ci) && !Character.isDigit(ci)) {
				i++;
				continue;
			}
			if (!Character.isLetter(cj) && !Character.isDigit(cj)) {
				j--;
				continue;
			}
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

}
