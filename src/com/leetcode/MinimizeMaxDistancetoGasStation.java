package com.leetcode;

public class MinimizeMaxDistancetoGasStation {
	/*
	 * refer this page for explanation
	 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/
	 * 113629/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
	 */

	public double minmaxGasDist(int[] stations, int K) {
		int d = stations[stations.length - 1] - stations[0];
		double lo = 0, hi = d;
		while (lo + 1e-6 <= hi) {
			int count = 0;
			double mid = (lo + hi) / 2;
			for (int i = 1; i < stations.length; ++i) {
				count += Math.ceil((stations[i] - stations[i - 1]) / mid) - 1;
			}
			if (count <= K)
				hi = mid;
			else
				lo = mid;
		}
		return lo;
	}

}
