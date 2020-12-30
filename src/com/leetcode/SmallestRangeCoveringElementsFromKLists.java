package com.leetcode;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.*;
import java.util.stream.Collectors;

/*
https://www.youtube.com/watch?v=Fqal25ZgEDo&feature=emb_title&ab_channel=IDeserve
 */

public class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> a) {
        int start = 0, end = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // Queue only contains row ad column of the numbers
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> a.get(o[0]).get(o[1])));
        for (int i = 0; i < a.size(); i++) {
            queue.offer(new int[]{i, 0});
            max = Math.max(max, a.get(i).get(0));
        }
        while(queue.size() == a.size()){
            int[] e = queue.poll();
            int row = e[0], col = e[1];
            if(end - start > max - a.get(row).get(col)){
                start = a.get(row).get(col);
                end = max;
            }
            if(col + 1 < a.get(row).size()){
                queue.offer(new int[]{row, col + 1});
                max = Math.max(max, a.get(row).get(col + 1));
            }
        }
        return new int[]{start,end};
    }

    public int[] smallestRange_slidingWindow(List<List<Integer>> a) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < a.size(); ++i){
            for(int n : a.get(i)){
                if(!map.containsKey(n)) map.put(n, new ArrayList<>());
                map.get(n).add(i);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        int l = 0, r = 0;
        int[] ans = new int[]{list.get(0), list.get(1)};
        int[] count = new int[a.size()];
        while(l < list.size()){
            while(r < list.size() && !allIn(count)){
                for(int t : map.get(list.get(r))) count[t]++;
                r++;
            }
            if(allIn(count) && list.get(r - 1) - list.get(l) < (ans[1] - ans[0])){
                ans = new int[]{list.get(l), list.get(r - 1)};
            }
            for(int m : map.get(list.get(l)))count[m]--;
            l++;
        }
        return ans;
    }

    private boolean allIn(int[] arr){
        for(int n : arr)
            if(n == 0) return false;
        return true;
    }

    public static void main(String[] args){
        List<List<Integer>> a = new ArrayList<>();
        int[][] arr = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        for(int[] r : arr)
            a.add(Arrays.stream(r).boxed().collect(Collectors.toList()));
        SmallestRangeCoveringElementsFromKLists sol = new SmallestRangeCoveringElementsFromKLists();
        int[] output = sol.smallestRange(a);
        System.out.println(output[0] + " : " + output[1]);
    }
}
