package com.leetcode;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length - 1;
		int end = 0;
		int gasInTank = gas[start] - cost[start];
		while (start > end) {
			if (gasInTank >= 0) {
				gasInTank += gas[end] - cost[end];
				end++;
			} else {
				--start;
				gasInTank += gas[start] - cost[start];
			}
		}
		if (gasInTank >= 0)
			return start;
		else
			return -1;

	}

	public static void main(String[] args) {
		int[] gas = { 1, 2 };// { 2, 3, 1, 3, 7, 5, 9, 1, 1 };
		int[] cost = { 2, 1 };// { 2, 7, 1, 1, 2, 6, 1, 1, 5 };
		GasStation sol = new GasStation();
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}
}
