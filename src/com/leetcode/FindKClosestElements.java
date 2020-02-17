package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	List<Integer> output = new ArrayList<Integer>();
    	int lo = 0, hi = arr.length - k;
    	while(lo < hi) {
    		int mid = (lo + hi) / 2;
    		if(x - arr[mid] > arr[mid + k] - x)
    			lo = mid + 1;
    		else hi = mid;
    	}
    	
    	for(int i = lo; i < lo + k; ++i) {
    		output.add(arr[i]);
    	}
    	return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
