package com.leetcode;

public class IntegertoRoman {

	public static String intToRoman(int num) {
		String output = null;
		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] M = { "", "M", "MM", "MMM" };
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}

}
