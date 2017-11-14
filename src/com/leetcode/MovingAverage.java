package com.leetcode;

import java.util.LinkedList;

public class MovingAverage {

	LinkedList<Integer> queue;
	int size;
	int sum;

	public MovingAverage(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) { // this function takes the next number and provides the average till now
		if (queue.size() < this.size) {
			queue.offer(val);
			sum += val;
		} else {
			int head = queue.poll();
			sum -= head;
			queue.offer(val);
			sum += val;
		}
		return (double) sum / queue.size();
	}

	public static void main(String[] args) {
		MovingAverage sol = new MovingAverage(6);
		System.out.println(sol.next(1));
		System.out.println(sol.next(2));
		System.out.println(sol.next(3));
		System.out.println(sol.next(4));
		System.out.println(sol.next(5));
		System.out.println(sol.next(6));
		System.out.println(sol.next(7));
		System.out.println(sol.next(8));
		System.out.println(sol.next(9));
	}
}
