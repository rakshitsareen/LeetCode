package com.leetcode;

import java.util.*;

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] d : distance)
            Arrays.fill(d, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        q.offer(new int[]{start[0], start[1], 0});
        // up down left right
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] point = q.poll();
            if(distance[point[0]][point[1]] < point[2]) continue;
            for (int p = 0; p < 4; p++) {
                int x = point[0];
                int y = point[1];
                int steps = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[p][0];
                    y += dir[p][1];
                    steps++;
                }
                // take a step back
                x -= dir[p][0];
                y -= dir[p][1];
                steps--;
                if (distance[point[0]][point[1]] + steps < distance[x][y]) {
                    distance[x][y] = distance[point[0]][point[1]] + steps;
                    q.offer(new int[]{ x, y, distance[x][y] });
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]] ;
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        TheMazeII mazeII = new TheMazeII();
        System.out.println(mazeII.shortestDistance(grid, new int[]{0,4}, new int[]{4,4}));
    }
}
