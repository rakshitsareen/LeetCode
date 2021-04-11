package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int len = 0;
        len = n;
        if(n > m){
            len = m;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; ++i) map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        List<Integer> res = new ArrayList<>();
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i) > 0){
                res.add(i);
                map.put(i,map.get(i) - 1);
                if(map.get(i) == 0) map.remove(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        int[] arr = {4,9,5}, brr = {9,4,9,8,4};
        IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();
        int[] res = intersection.intersect(arr, brr);
        for(int i : res) System.out.println(i);
    }
}
