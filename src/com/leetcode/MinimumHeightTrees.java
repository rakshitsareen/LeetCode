package com.leetcode;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> output = new ArrayList<>();
        if(n <= 2){
            while(n > 0){
                output.add(n - 1);
                n--;
            }
            return output;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for(int[] edge : edges){
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n; ++i){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            output.clear();
            while(size -- > 0){
                int curr = q.poll();
                output.add(curr);
                for(int i : map.get(curr)){
                    degree[i]--;
                    if(degree[i] == 1)
                        q.offer(i);
                }
            }
        }
        return output;
    }
}
