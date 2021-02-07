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

/*

 class MedianFinder {

    PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue();

    public MedianFinder() {

    }

    public void addNum(int num) {
       min.offer(num);
       max.offer(min.poll());
       if(min.size() < max.size()){
         min.offer(max.poll());
       }
    }

    public double findMedian() {
       if(min.size() == max.size()){
         return (min.peek() + max.peek()) / 2.0;
       } else {
         return min.peek();
       }
    }
}
 */
