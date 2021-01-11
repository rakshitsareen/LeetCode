package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    class UnionFind{
        int[] parents, rank;
        public UnionFind(int n){
            parents = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; ++i) parents[i] = i;
        }

        public int find(int node){
            if(node == parents[node]) return node;
            return parents[node] = find(parents[node]);
        }

        public void union(int a, int b){
            int x = find(a), y = find(b);
            if(x != y){
                if(rank[x] > rank[y]){
                    int temp = y;
                    y = x;
                    x = temp;
                }
                parents[x] = y;
                rank[y] += rank[x];
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        List<int[]> qlist = new ArrayList<>();
        for(int i = 0; i < queries.length; ++i){
            qlist.add(new int[]{queries[i][0], queries[i][1], queries[i][2], i});
        }
        Collections.sort(qlist, (a, b) -> a[2] - b[2]);
        int i = 0;
        UnionFind unionFind = new UnionFind(n);
        for(int[] q : qlist){
            while(i < edgeList.length && q[2] > edgeList[i][2]) {
                unionFind.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            // if parents are same, they are in one connected component.
            result[q[3]] = unionFind.find(q[0]) == unionFind.find(q[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] e = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}};
        int[][] q = {{0,1,2},{0,2,5}};
        CheckingExistenceOfEdgeLengthLimitedPaths sol = new CheckingExistenceOfEdgeLengthLimitedPaths();
        boolean[] result = sol.distanceLimitedPathsExist(3, e, q);
        for(boolean res : result)
            System.out.println(res);
    }
}