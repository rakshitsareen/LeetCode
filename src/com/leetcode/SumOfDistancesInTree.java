package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOfDistancesInTree {
    int[] ans, count;
    int N;
    List<HashSet<Integer>> graph;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int node, int parent){
        for(int child : graph.get(node)){
            if(child == parent) continue;
            dfs(child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }

    private void dfs2(int node, int parent){
        for(int child : graph.get(node)){
            if(child != parent){
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
}
