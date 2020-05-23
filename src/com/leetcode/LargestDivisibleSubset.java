package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<ArrayList<Integer>> EDS = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            EDS.add(new ArrayList<>());
        }
        for(int i = 0; i < nums.length; ++i){
            List<Integer> maxsubset = new ArrayList<>();
            for(int k = 0; k < i; ++k){
                if(nums[i]%nums[k] == 0 && maxsubset.size() < EDS.get(k).size())
                    maxsubset = EDS.get(k);
            }
            EDS.get(i).addAll(maxsubset);
            EDS.get(i).add(nums[i]);
        }
        for(int i = 0; i < nums.length; ++i){
            if(res.size() < EDS.get(i).size()) res = EDS.get(i);
        }
        return res;
    }
}
