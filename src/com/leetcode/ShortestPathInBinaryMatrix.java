package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null) return -1;
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int level = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                if(curr[0] == n - 1 && curr[1] == n -1) return level + 1;
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x>=0 && y>=0 && y<n && x<n && grid[x][y] == 0 && !visited[x][y]){
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
