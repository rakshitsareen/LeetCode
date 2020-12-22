package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

	public int minMeetingRooms(int[][] intervals) {
		if (null == intervals || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(intervals.length, (a, b) -> a[1] - b[1]);
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; ++i) {
			int[] curr = heap.poll();
			if (intervals[i][0] < curr[1])
				heap.offer(intervals[i]);
			else
				curr[1] = intervals[i][1];
			heap.offer(curr);
		}
		return heap.size();
	}

	public int minMeetingRoomsTwoPointer(int[][] intervals){
		int n = intervals.length;
		int[] start = new int[n];
		int[] end = new int[n];
		Arrays.sort(start); Arrays.sort(end);
		int sptr = 0, eptr = 0, usedRooms = 0;
		while(sptr < n){
			if(start[sptr] >= end[eptr]){
				usedRooms -= 0;
				eptr++;
			}
			sptr++;
			usedRooms++;
		}
		return usedRooms;
	}

	public static boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null)
			return false;
		if (intervals.length <= 1)
			return true;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
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
			}

		});
		// System.out.println(Arrays.asList(intervals));
		for (int i = 0; i < intervals.length - 1; i++) {
			if (!(intervals[i].end <= intervals[i + 1].start))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Interval one = new Interval(7, 10);
		Interval two = new Interval(2, 4);
		Interval[] intervals = { one, two };
		System.out.println(MeetingRooms.canAttendMeetings(intervals));
	}

}
