package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortKings {

	static class King {
		String name;
		int num;

		public King(String name, int num) {
			this.name = name;
			this.num = num;
		}
	}

	static String[] getSortedList(String[] names) {
		if (names.length == 1)
			return names;
		King[] kings = new King[names.length];
		HashMap<King, String> kingName = new HashMap<>();
		String[] ans = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			String[] name = names[i].split(" ");
			int num = toInt(name[1]);
			King k = new King(name[0], num);
			kings[i] = k;
			kingName.put(k, names[i]);
		}
		Arrays.sort(kings, new Comparator<King>() {

			@Override
			public int compare(King o1, King o2) {
				String k1 = o1.name;
				String k2 = o2.name;

				if (k1.compareTo(k2) != 0)
					return k1.compareTo(k2);
				else {
					return o1.num - o2.num;
				}
			}
		});
		for (int i = 0; i < kings.length; i++) {
			ans[i] = kingName.get(kings[i]);
		}
		return ans;
	}

	public static int toInt(String s) {
		int sum = 0;
		char[] c = s.toCharArray();
		if (s.indexOf("XL") != -1)
			sum -= 20;
		if (s.indexOf("IX") != -1)
			sum -= 2;
		if (s.indexOf("IV") != -1)
			sum -= 2;
		for (int i = 0; i < s.length(); i++) {
			if (c[i] == 'I')
				sum += 1;
			if (c[i] == 'V')
				sum += 5;
			if (c[i] == 'X')
				sum += 10;
			if (c[i] == 'L')
				sum += 50;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
