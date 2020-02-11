package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream {

	Queue<Integer> small, large;

	/** initialize your data structure here. */
	public FindMedianfromDataStream() {
		small = new PriorityQueue<Integer>();
		large = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		large.add(num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll()); // this is -ve because we inserted in small after negating
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}

	public static void main(String[] args) {

	}

}
