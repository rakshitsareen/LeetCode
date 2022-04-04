package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});
        int[][]seen = new int[m][n];
        for(int i = 0; i < m; ++i){
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        int steps = 0;
        int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
        seen[0][0] = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(sz-- > 0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int kTillNow = cur[2];
                if(x == m-1 && y == n-1) return steps;
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    int nk = kTillNow + grid[nx][ny];
                    if(nk >= seen[nx][ny] || nk > k) continue; // more than seen minimum number of obstacles or more than allowed number of obstacles to jump
                    seen[nx][ny] = nk;  // mark the kth entry of this new x and y
                    queue.offer(new int[]{nx,ny,nk});
                }
            }
            steps++;
        }
        return -1;
    }
}
