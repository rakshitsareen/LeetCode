package com.leetcode;

import java.util.Arrays;

public class FriendCircles {
    public int findCircleNum(int[][] m) {
        int[] visited = new int[m.length];
        int output = 0;
        for(int i = 0; i < m.length; ++i){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(m, visited, i);
                output++;
            }
        }
        return output;
    }

    public void dfs(int[][] m, int[] visited, int i){
        for(int j = 0; j < m.length; ++j){
            if(m[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(m,visited, j);
            }
        }
    }

    // using union-find algo, impl below
    public int findCircleNumUnionFind(int[][] m) {
        int[] parent = new int[m.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < m.length; ++i)
            for(int j = 0; j < m[0].length; ++j)
                if(m[i][j] == 1 && i != j){
                    union(parent, i, j);
                }
        int output = 0;
        for (int j : parent) {
            if (j == -1) output++;
        }
        return output;
    }

    public int find(int[]parent, int i){
        if(parent[i] == -1) return i;
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int i, int j){
        int parentx = find(parent, i);
        int parenty = find(parent, j);
        if(parenty != parentx)
            parent[parentx] = parenty;
    }
}
