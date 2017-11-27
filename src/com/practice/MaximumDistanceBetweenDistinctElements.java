package com.practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumDistanceBetweenDistinctElements {

	public static int solution(int[] A) {
		int N = A.length;
		int result = 0;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = N - 1; i >= 0; i--) { // populate HashMap
			if (!map.containsKey(A[i]))
				map.put(A[i], i);
		}
		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		for (int i = 0; i < N; i++) {
			Entry<Integer, Integer> temp = null;
			if (itr.hasNext())
				temp = itr.next();
			int key = temp.getKey();
			while (A[i] == key) {
				if (itr.hasNext()) {
					temp = itr.next();
					key = temp.getKey();
				} else {
					return result;
				}
			}
			result = Math.max(result, Math.abs(temp.getValue() - i));
			itr = map.entrySet().iterator(); // reset iterator
		}
		return result;
	}

	public static void main(String[] args) {
		// int[] A = { 4, 6, 2, 2, 6, 6, 4 };
		// int[] A = { 1, 2, 3, 4, 5, 6, 7 };
		// int[] A = { 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2 };
		int[] A = { -2, 2, 2, 3, 2, 2, 2, -2 };
		/*
		 * int A[] = new int[75001]; for (int i = 0; i <= 75000; i++) A[i] = i;
		 */
		System.out.println(solution(A));
	}

}
