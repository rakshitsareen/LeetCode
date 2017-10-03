package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.LinkedList;

public class PowerSet {

	public ArrayList<LinkedList<Integer>> getAllSubsets(int[] a) {
		if (a == null || a.length == 0)
			return null;
		ArrayList<LinkedList<Integer>> subsets = new ArrayList<>();
		getAllSubsets(a, 0, a.length - 1, subsets);
		return subsets;

	}

	public ArrayList<LinkedList<Integer>> getAllSubsets(int[] a, int start, int end,
			ArrayList<LinkedList<Integer>> subsets) {
		/*
		 * do a recursive call till we get only one element;
		 */
		if (start > end)
			return null;
		
		if (end - start == 0) { // if there is only one element.
			LinkedList<Integer> list = new LinkedList<>();
			list.add(a[start]);
			subsets.add(list);
			return subsets;
		}
		// now we will remove head from the array and generate all subsets from the
		// remaining list.
		getAllSubsets(a, start + 1, end, subsets); // this will fill subsets with subsets of the remaining array.

		// after we get all the subsets from the remaning array, we will weave this
		// present element into
		// all the lists that are present in the subsets data structure and produce new
		// subsets.
		/*
		 * Algorithm: for all lists in subsets generte new lists with a[start] added to
		 * them.
		 */

		for (LinkedList<Integer> list : subsets) {
			LinkedList<Integer> newList = new LinkedList<>();
			newList.add(a[start]);
			newList.addAll(list);
			subsets.add(newList);
		}

		return subsets;
	}

	public static void main(String[] args) {
		PowerSet sol = new PowerSet();
		int[] a = {1,2,3,4};
		sol.getAllSubsets(a);
	}

}
