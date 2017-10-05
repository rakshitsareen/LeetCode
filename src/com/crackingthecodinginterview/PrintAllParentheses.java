package com.crackingthecodinginterview;

import java.util.ArrayList;

public class PrintAllParentheses {

	public static void printAllParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem)
			return; // invalid state
		if (leftRem == 0 && rightRem == 0) { // Out of left and right parentheses
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '('; //  Add left and recurse
			printAllParens(list, leftRem - 1, rightRem, str, index + 1);

			str[index] = ')'; //  Add right and recurse
			printAllParens(list, leftRem, rightRem - 1, str, index + 1);
		}
	}

	public static void pap(int n) {
		if (n == 0)
			return;
		char[] a = new char[n * 2];
		paputil(n, a, 0);
	}

	private static void paputil(int n, char[] a, int loc) {
		if (loc + 1 < a.length) {
			a[loc] = '(';
			a[loc + 1] = ')';
			paputil(n - 1, a, loc + 2);
		}
		if (loc + 2 < a.length) {
			System.out.println();
			a[loc] = '(';
			paputil(n - 1, a, loc + 1);
			a[a.length - loc - 1] = ')';
		}

		if (n == 0) {
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i]);
		}
		return;
	}

	public static void main(String[] args) {
		char[] str = new char[21];
		ArrayList<String> list = new ArrayList<>();
		PrintAllParentheses.printAllParens(list, 10, 10, str, 0);
		for(String strg : list) {
			System.out.println(strg);
		}
	}

}
