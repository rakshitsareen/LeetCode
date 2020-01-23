package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDatainLogFiles {

	public String[] reorderLogFiles(String[] logs) {
		if (null == logs)
			return null;
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int ss1 = o1.indexOf(' ');
				int ss2 = o2.indexOf(' ');
				char ss1c = o1.charAt(ss1 + 1);
				char ss2c = o2.charAt(ss2 + 1);
				if (ss1c <= '9') {
					if (ss2c <= '9')
						return 0;
					else
						return 1;
				}
				if (ss2c <= '9')
					return -1;
				int output = o1.substring(ss1 + 1).compareTo(o2.substring(ss2 + 1));
				if (0 == output)
					return o1.substring(0, ss1).compareTo(o2.substring(0, ss2));
				return output;
			}

		};
		Arrays.sort(logs, comp);
		return logs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
