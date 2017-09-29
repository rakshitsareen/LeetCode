package com.crackingthecodinginterview;

public class MagicIndex {

	public int magicIndex(int[] arr) {
		int a = magicIndexUtil(arr, 0, arr.length-1);
		return (a >= 0) ? a : -1;
	}

	public int magicIndexUtil(int[] a, int start, int end) {
		if (a == null || a.length == 0)
			return -1;
		if (start > end)
			return -1;
		if (start == end) {
			return a[start] == start ? start : -1;
		}

		int mid = (start + end) / 2;

		if (a[mid] == mid)
			return mid;
		if (a[mid] < mid)
			return magicIndexUtil(a, mid + 1, end);
		if (a[mid] > mid)
			return magicIndexUtil(a, start, mid - 1);
		return -1;
	}

	public static void main(String[] args) {
		
		MagicIndex sol = new MagicIndex();
		int [] a  = {-1,0,1,2,4,7,8,9,10};
		int [] b = {5,5,5,5,5,5,5,5,5,5};	// in this case we need to traverse the array. binary search will not apply.
		System.out.println(sol.magicIndex(a));
	}
}
