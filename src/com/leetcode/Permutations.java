package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	// Given a collection of distinct integers, return all possible permutations.
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res, new ArrayList<Integer>(), nums);
		return res;
	}
	
	private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
		if(list.size() == nums.length) {res.add(new ArrayList<Integer>(list)); return;}
		else {
			for(int i = 0; i < nums.length; ++i) {
				int a = nums[i];
				if(list.contains(a)) continue;
				list.add(a);
				backtrack(res, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}

}
