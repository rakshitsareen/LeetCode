package com.leetcode;

public class Escape {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "\\";
		String s_new = s.replaceAll("\\\\\\\\","\\\\");
		System.out.println(s_new);
	}
}
