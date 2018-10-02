package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> lo = null;
	PriorityQueue<Integer> hi = null;

	public MedianFinder() {
		lo = new PriorityQueue<>(10, Collections.reverseOrder()); // maxheap
		hi = new PriorityQueue<>(); // minheap
	}

	public void addNum(int num) {
		lo.offer(num);
		hi.offer(lo.poll());
		if (lo.size() < hi.size()) {
			lo.offer(hi.poll());
		}
	}

	public double findMedian() {
		if (lo.size() == hi.size())
			return (lo.peek() + hi.peek()) * 0.5;
		return lo.peek();
	}

	public static void main(String[] args) {

	}

}
