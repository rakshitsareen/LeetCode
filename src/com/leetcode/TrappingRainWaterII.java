package com.leetcode;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(1, (a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            q.offer(new int[]{0,i,heightMap[0][i]});
            q.offer(new int[]{m-1,i,heightMap[m-1][i]});
        }
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            q.offer(new int[]{i, 0, heightMap[i][0]});
            q.offer(new int[]{i, n-1, heightMap[i][n-1]});
        }

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int water = 0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] dir : dirs){
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if(x < m && y < n && x >= 0 && y >=0 && !visited[x][y]){
                    visited[x][y]= true;
                    water += Math.max(0, cell[2] - heightMap[x][y]);
                    q.offer(new int[] {x,y, Math.max(cell[2], heightMap[x][y])});
                }
            }
        }
        return water;
    }
}
