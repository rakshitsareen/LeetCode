package com.leetcode;

public class ReverseString {

	public static String reverseString(String str) {
		if (str == null || str.length() == 0 || str.length() == 1)
			return str;
		StringBuilder output = new StringBuilder(str);
		int i = 0, j = str.length() - 1;
		while (i < j) {
			char temp = output.charAt(i);
			output.setCharAt(i, output.charAt(j));
			output.setCharAt(j, temp);
			i++;
			j--;
		}
		return output.toString();
	}

	public static void main(String[] args) {
		System.out.println(ReverseString.reverseString("abcdefghijklmnopqrstuvwxyz"));
	}

}
