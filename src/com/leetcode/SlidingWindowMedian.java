package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

	PriorityQueue<Integer> minheap = new PriorityQueue<>();
	PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});

	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length - k + 1;
		if(n <= 0) return new double[0];
		double[] result = new double[n];
		for(int i = 0; i <= nums.length; ++i){
			if(i >= k){
				result[i - k] = getMedian();
				remove(nums[i - k]);
			}
			if(i < nums.length){
				add(nums[i]);
			}
		}
		return result;
	}

	private void add(int num){
		if(num < getMedian())
			maxheap.add(num);
		else
			minheap.add(num);
		if(maxheap.size() > minheap.size()){
			minheap.add(maxheap.poll());
		}
		if(minheap.size() - maxheap.size() > 1){
			maxheap.add(minheap.poll());
		}
	}

	private void remove(int num){
		if(num < getMedian()){
			maxheap.remove(num);
		}else minheap.remove(num);
		if(maxheap.size() > minheap.size()){
			minheap.add(maxheap.poll());
		}
		if(minheap.size() - maxheap.size() > 1){
			maxheap.add(minheap.poll());
		}
	}

	private double getMedian() {
		if(maxheap.isEmpty() && minheap.isEmpty()) return 0;
		if(maxheap.size() == minheap .size())
			return ((double)maxheap.peek() + (double) minheap.peek())/2.0;
		else
			return (double) minheap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
