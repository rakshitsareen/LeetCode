package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null)
			return 0;
		if (intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval poll = heap.poll();
			if (poll.end <= intervals[i].start) {
				poll.end = intervals[i].end;
			} else
				heap.offer(intervals[i]);
			heap.offer(poll);
		}
		return heap.size();
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
