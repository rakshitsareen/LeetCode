package com.leetcode;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		int maxpile = getMaxPile(piles);
		System.out.println(maxpile);
		int lo = 1, hi = maxpile;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (canEatAll(piles, mid, H))
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return lo;
	}

	private boolean canEatAll(int[] piles, int k, int H) {
		int hours = 0;
		for (int pile : piles) {
			hours += pile / k;
			if (pile % k != 0) {
				hours++;
			}
		}
        return hours <= H;
    }

	private int getMaxPile(int[] piles) {
		int output = 0;
		for (int pile : piles) {
			output = Math.max(pile, output);
		}
		return output;
	}
}
