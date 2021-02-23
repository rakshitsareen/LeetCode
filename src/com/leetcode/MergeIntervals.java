package com.leetcode;

import org.jetbrains.annotations.TestOnly;

import java.lang.reflect.Array;
import java.util.*;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		Arrays.sort(intervals, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				if (o1[1] == o2[1]) return 0;
				else return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		int start = intervals[0][0], end = intervals[0][1];
		for(int[] interval : intervals){
			if(interval[0] <= end){
				end = Math.max(end, interval[1]);
			}
			else{
				result.add(new int[]{start, end});
				start = interval[0];
				end = interval[1];
			}
		}
		result.add(new int[]{start, end});
		return result.toArray(new int[result.size()][]);
	}

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null)
			return null;
		if (intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, (o1, o2) -> {
			if (o1.start < o2.start)
				return -1;
			if (o1.start > o2.start)
				return 1;
			if (o1.start == o2.start) {
				if (o1.end == o2.end)
					return 0;
				if (o1.end < o2.end)
					return -1;
				if (o1.end > o2.end)
					return 1;
			}
			return 0;
		});
		List<Interval> answer = new ArrayList<>();

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval in : intervals) {
			if (in.start <= end) { // i overlap with the previous one.
				end = Math.max(end, in.end);
			} else {
				answer.add(new Interval(start, end));
				start = in.start;
				end = in.end;
			}
		}
		answer.add(new Interval(start, end));
		return answer;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		List<Interval> result = MergeIntervals.merge(intervals);
		System.out.println(result);
	}

}
