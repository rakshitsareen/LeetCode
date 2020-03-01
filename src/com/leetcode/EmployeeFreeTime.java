package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> res = new ArrayList<>();
		List<Interval> timeline = new ArrayList<>();
		schedule.forEach(p -> timeline.addAll(p));
		Collections.sort(timeline, (a, b) -> a.start - b.start);
		Interval temp = timeline.get(0);
		for (Interval each : timeline) {
			if (temp.end < each.start) {
				res.add(new Interval(temp.end, each.start));
				temp = each;
			} else {
				temp = temp.end < each.end ? each : temp;
			}
		}
		return res;
	}
}
