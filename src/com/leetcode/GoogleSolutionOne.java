package com.leetcode;

public class GoogleSolutionOne {

	public String solution(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int min = Integer.parseInt(time.substring(3, 5));
		if(hour == min) return time;
		while (true) {
			if (--min < 0) {
				min = 59;
				--hour;
				hour %= 24;
			}
			String curr = String.format("%02d:%02d", hour, min);
			Boolean valid = true;
			for (int i = 0; i < curr.length(); ++i)
				if (time.indexOf(curr.charAt(i)) < 0) {
					valid = false;
					break;
				}
			if (valid)
				return curr;
		}
	}

	public static void main(String[] args) {
		GoogleSolutionOne ans = new GoogleSolutionOne();
		System.out.println(ans.solution("11:10"));
	}

}
