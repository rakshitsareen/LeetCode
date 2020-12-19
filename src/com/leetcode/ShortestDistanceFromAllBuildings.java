package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] reach = new int[m][n];
        int buildings = 0;
        int [][] distance = new int[m][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    buildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean [][] visited = new boolean[m][n];
                    queue.offer(new int[]{i,j});
                    int level = 1;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        while(size -- > 0) {
                            int[] curr = queue.poll();
                            for (int[] dir : dirs) {
                                assert curr != null;
                                int x = curr[0] + dir[0];
                                int y = curr[1] + dir[1];
                                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 0) {
                                    distance[x][y] += level;
                                    reach[x][y]++;
                                    visited[x][y] = true;
                                    queue.offer(new int[]{x, y});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && reach[i][j] == buildings){
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
