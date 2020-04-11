package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC24Game {
	boolean ans = false;

	public boolean judgePoint24(int[] nums) {
		List<Double> arr = new ArrayList<Double>();
		for (int n : nums)
			arr.add((double) n);
		helper(arr);
		return ans;
	}

	private void helper(List<Double> arr) {
		if (ans)
			return;
		if (arr.size() == 1) {
			Double a = arr.get(0);
			if (Math.abs(a - 24.0) < 0.001)
				ans = true;
			return;
		}
		for (int i = 0; i < arr.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				List<Double> next = new ArrayList<>();
				Double p1 = arr.get(i);
				Double p2 = arr.get(j);
				next.addAll(Arrays.asList(p1 + p2, p1 * p2, p1 - p2, p2 - p1));
				if (Math.abs(p2) > 0.001)
					next.add(p1 / p2);
				if (Math.abs(p1) > 0.001)
					next.add(p2 / p1);
				arr.remove(i);
				arr.remove(j);
				for (Double num : next) {
					arr.add(num);
					helper(arr);
					arr.remove(arr.size() - 1);
				}
				arr.add(j, p2);
				arr.add(i, p1);
			}
		}
	}
}
