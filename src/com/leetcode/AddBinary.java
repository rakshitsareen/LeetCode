package com.leetcode;

public class AddBinary {

	static int carry;

	public static int addBit(int x, int y) {
		if (x == 1 && y == 1) {
			if (carry == 1)
				return 1;
			carry = 1;
			return 0;
		}

		if (x == 0 && y == 0) {
			if (carry == 1) {
				carry = 0;
				return 1;
			} else
				return 0;
		}
		if (carry == 1) {
			// carry = 0;
			return 0;
		}
		return 1;
	}

	public static String addBinary(String a, String b) {
		if (a == null && b == null)
			return null;
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		int lena = a.length();
		int lenb = b.length();
		StringBuilder output = new StringBuilder();
		while (lena > 0 || lenb > 0) {
			int ans = 0;
			if (lena > 0 && lenb > 0)
				ans = addBit(Integer.parseInt(Character.toString(a.charAt(lena - 1))),
						Integer.parseInt(Character.toString(b.charAt(lenb - 1))));
			else if (lena > 0)
				ans = addBit(Integer.parseInt(Character.toString(a.charAt(lena - 1))), 0);
			else
				ans = addBit(Integer.parseInt(Character.toString(b.charAt(lenb - 1))), 0);
			output.append(ans);
			lena--;
			lenb--;
		}
		if (carry > 0)
			output.append(carry);
		carry = 0;
		return output.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(AddBinary.addBinary("1", "1"));
		System.out.println(AddBinary.addBinary("001", "001"));
		System.out.println(AddBinary.addBinary("0", "1"));
		System.out.println(AddBinary.addBinary("1", "0"));
		System.out.println(AddBinary.addBinary("11", "1"));
		System.out.println(AddBinary.addBinary("11", "11"));
		System.out.println(AddBinary.addBinary("101", "11"));
		System.out.println(AddBinary.addBinary("1111", "1111"));
		System.out.println(AddBinary.addBinary("1010", "1011"));

	}

}
