package com.leetcode;

import java.util.TreeSet;

public class MaximizeDistancetoClosestPerson {

	public static int maxDistToClosest(int[] seats) {
		int mlen = 0;
		int last_one = 0;
		int first_one = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < seats.length; i++)
			if (seats[i] == 1) {
				if (first_one == 0) {
					first_one = i;
				}
				set.add(i);
				last_one = i;
			}
		if (first_one != 0)
			set.add(-first_one);
		if (last_one != seats.length - 1) // there was no one sitting on the last seat
			set.add(seats.length - 1 + (seats.length - 1 - last_one));
		for (int i = 0; i < seats.length; i++)
			if (seats[i] == 0) {
				int lo = set.lower(i);
				int hi = set.higher(i);
				mlen = Math.max(mlen, (hi - lo) / 2);
			}
		return mlen;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 0, 0 };
		System.out.println(maxDistToClosest(a));
	}
}
