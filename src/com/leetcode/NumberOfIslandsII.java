package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> output = new ArrayList<>();
        if(m <= 0 || n <= 0) return output;
        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[] parents = new int[m*n];
        Arrays.fill(parents, -1);
        for(int[] pos : positions){
            int x = pos[0], y = pos[1];
            int current = n * x + y;
            if(parents[current] != -1){
                output.add(count); continue;
            }
            parents[current] = current;
            count++;
            for(int[] dir : dirs){
                int a = x + dir[0];
                int b = y + dir[1];
                int neighbor = a * n + b;
                if(a < 0 || b < 0 || a >= m || b >= n || parents[neighbor] == -1) continue;
                int neighborParent = find(neighbor, parents);
                if(neighborParent != current){
                    parents[current] = neighborParent;
                    current = neighborParent;
                    count--;
                }
            }
            output.add(count);
        }
        return output;
    }

    public int find(int node, int[] parents){
        while(node != parents[node]) node = parents[node];
        return node;
    }
}
