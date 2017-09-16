package com.crackingthecodinginterview;

public class OneAway {

	public boolean oneAway(String s, String t) {
		// base cases
		if (s == null && t == null)
			return true;
		if (s.isEmpty() && t.isEmpty())
			return true;
		int m = s.length();
		int n = t.length();
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		int nEdits = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (s.charAt(i) != t.charAt(j)) {
				nEdits++;
				if (nEdits > 1)
					return false;
				if (m != n) {
					if (m > n) {
						i++;
					} else {
						j++;
					}
				} else {
					i++;
					j++;
				}
			}
			else {
				i++;j++;
			}

		}
		return nEdits<=1;
	}

	public static void main(String[] args) {
		OneAway sol = new OneAway();
		System.out.println(sol.oneAway("pale", "pakke"));
		System.out.println(sol.oneAway("pale", "pae"));
		return;
	}

}
