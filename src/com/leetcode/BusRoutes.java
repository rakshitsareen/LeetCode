package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = routes.length;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < m; ++i){
            for(int stop : routes[i]){
                map.putIfAbsent(stop, new ArrayList<Integer>());
                map.get(stop).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            while(size-- > 0){
                int s = q.poll();
                List<Integer> buses = map.get(s);
                for(int bus : buses){
                    if(visited.contains(bus)) continue;
                    visited.add(bus);
                    for(int stop : routes[bus]){
                        if(stop == T) return res;
                        q.offer(stop);
                    }
                }
            }
        }
        return -1;
    }
}
