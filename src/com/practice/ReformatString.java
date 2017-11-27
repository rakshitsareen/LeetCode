package com.practice;

public class ReformatString {

	public static String reformat(String S, int k) {
		if (S == null)
			return S;
		if (k <= 0)
			return S.toUpperCase();
		if (k >= S.length())
			return S.toUpperCase();
		StringBuilder result = new StringBuilder();
		String temp = S.replaceAll("-", "").toUpperCase();
		int len = temp.length();
		// System.out.println(temp);
		len = temp.length();
		while (len - k >= 0) {
			if (len - k > 0) {
				result.insert(0, temp.substring(len - k, len));
				result.insert(0, "-");
				// System.out.println(result);
			} else {
				// System.out.println("here too");
				result.insert(0, temp.substring(len - k, len));
				// System.out.println(result);
			}
			len = len - k;
		}
		if (len - k < 0) { // some characters in the original string remain.
			// System.out.println("here");
			result.insert(0, temp.substring(0, len));
			// System.out.println(result);
		}
		// result.reverse();
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(reformat("2-4A0r7-4k", 3));
	}

}
