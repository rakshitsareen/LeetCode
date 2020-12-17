package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GSSolutionOne {

	public static int minSliceCut(int[][] nums) {
		if (nums == null)
			return 0;
		int rows = nums.length;
		if (rows == 0)
			return 0;
		int cols = nums[0].length;
		if (cols == 0)
			return 0;
		int[][] dp = new int[rows][cols];
		// save the last line
		for (int i = 0; i < cols; i++) {
			dp[rows - 1][i] = nums[rows - 1][i];
		}
		// start from one above and memoize
		for (int i = rows - 2; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				int k = -1;
				int minVal = Integer.MAX_VALUE;
				while (k <= 1) {
					if (j + k >= 0 && j + k < cols) {
						int newVal = dp[i + 1][j + k];
						minVal = Math.min(minVal, newVal);
					}
					k++;
				}
				dp[i][j] = minVal + nums[i][j];
			}
		}
		int minVal = dp[0][0];
		for (int i = 0; i < cols; i++) {
			minVal = Math.min(minVal, dp[0][i]);
		}
		return minVal;
	}

	static class Pair {
		int total_late;
		int freq;

		public Pair(int late, int freq) {
			this.total_late = late;
			this.freq = freq;
		}
	}

	public static String latestStudent(List<List<String>> attendanceData) {
		if (attendanceData == null)
			return "";
		if (attendanceData.size() == 0)
			return "";
		Map<String, Pair> date_late = new HashMap<>();
		Map<String, Float> student_relativeLate = new HashMap<>();
		String date;
		int ctime = 0, etime = 0;
		for (List<String> list : attendanceData) {
			date = list.get(0);
			etime = Integer.parseInt(list.get(3));
			ctime = Integer.parseInt(list.get(2));
			int increase = etime - ctime > 0 ? etime - ctime : 0;
			if (date_late.get(date) == null) {
				date_late.put(date, new GSSolutionOne.Pair(increase, 1));
			} else {
				GSSolutionOne.Pair p = date_late.get(date);
				int total = p.total_late + increase;
				p = new GSSolutionOne.Pair(total, p.freq + 1);
				date_late.put(date, p);
			}
		}
		// date_late populated, now populate student_relativeLate
		String name = null;
		float avg = 0f;
		float maxRLate = 0;
		for (List<String> list : attendanceData) {
			name = list.get(1);
			date = list.get(0);
			etime = Integer.parseInt(list.get(3));
			ctime = Integer.parseInt(list.get(2));
			GSSolutionOne.Pair p = date_late.get(date);
			// if(p == null)
			// continue;
			avg = (float) date_late.get(date).total_late / (float) date_late.get(date).freq;
			if (etime - ctime > avg) {
				float currLateness = etime - ctime - avg;
				if (student_relativeLate.get(name) == null) {
					if (maxRLate < currLateness)
						maxRLate = currLateness;
					student_relativeLate.put(name, currLateness);
				} else {
					float rlate = student_relativeLate.get(name);
					rlate += (currLateness);
					if (maxRLate < rlate)
						maxRLate = rlate;
					student_relativeLate.put(name, rlate);
				}
			}
		}
		// student relative lateness populated.
		List<String> result = new ArrayList<>();
		Iterator it = student_relativeLate.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Float> pair = (Map.Entry<String, Float>) it.next();
			if (pair.getValue() == maxRLate) {
				result.add(pair.getKey());
			}
		}
		Collections.sort(result);
		if (result.size() > 0)
			return result.get(0);
		return "";
	}

	public static void main(String[] args) {
		// int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// System.out.println(GSSolutionOne.minSliceCut(nums));
		List<List<String>> test = new ArrayList<List<String>>();
		System.out.println(5 / 3);
	}

}
