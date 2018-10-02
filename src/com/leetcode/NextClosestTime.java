package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

	public String nextClosestTime(String time) {
		Integer curr = 60 * Integer.parseInt(time.substring(0, 2));
		curr += Integer.parseInt(time.substring(3));
		Set<Integer> allowed = new HashSet<>();
		for (char c : time.toCharArray())
			if (c != ':') {
				allowed.add(c - '0');
			}
		while (true) {
			boolean done = true;
			curr = (curr + 1) % (24 * 60);
			int[] digits = new int[] { curr / 60 / 10, curr / 60 % 10, curr % 60 / 10, curr % 60 % 10 };
			for (int d : digits)
				if (!allowed.contains(d)) {
					done = false;
					break;
				}
			if (done)
				return new StringBuilder().append(digits[0]).append(digits[1]).append(":").append(digits[2])
						.append(digits[3]).toString();
		}
	}

	public static void main(String[] args) {
		NextClosestTime ans = new NextClosestTime();
		System.out.println(ans.nextClosestTime("19:34"));

	}

}
