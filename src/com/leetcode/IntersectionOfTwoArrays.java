package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> n1 = new HashSet<Integer>(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
		Set<Integer> n2 = new HashSet<Integer>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
		List<Integer> res = new ArrayList<>();
		for (int i : n1)
			if (n2.contains(i))
				res.add(i);
		return res.stream().mapToInt(i -> i).toArray();
	}
}
