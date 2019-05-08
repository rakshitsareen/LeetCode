package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, 
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls.
 *  The start and destination coordinates are represented by row and column indexes.
 */

public class TheMaze {

	int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		q.offer(start);
		visited[start[0]][start[1]] = true;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point[0] == destination[0] && point[1] == destination[1])
				return true;
			for (int p = 0; p < 4; p++) {
				int x = point[0];
				int y = point[1];
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[p][0];
					y += dir[p][1];
				}
				// take a step back
				x -= dir[p][0];
				y -= dir[p][1];
				if (visited[x][y])
					continue;
				visited[x][y] = true;
				q.offer(new int[] { x, y });
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
