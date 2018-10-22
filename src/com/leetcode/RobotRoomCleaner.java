package com.leetcode;

import java.util.HashSet;
import java.util.Set;

interface Robot {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell.
	boolean move();

	// Robot will stay on the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	void turnLeft();

	void turnRight();

	// Clean the current cell.
	void clean();
}

public class RobotRoomCleaner {

	final int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object o) {
			Pair node = (Pair) o;
			if (node.row == row && this.col == col) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int res = 17;
			res = res * 31 + row;
			res = res * 31 + col;
			return res;
		}
	}

	public void dfs(Robot robot, Set<Pair> vst, int x, int y, int curDir) {
		Pair p = new Pair(x, y);
		vst.add(p);
		robot.clean();
		for (int i = 0; i < 4; i++) { // for all 4 directions
			int direction = (curDir + i) % 4;
			Pair next = new Pair(x + directions[direction][0], y + directions[direction][1]);
			if (!vst.contains(next) && robot.move()) {
				dfs(robot, vst, x + directions[direction][0], y + directions[direction][1], direction);
				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				robot.turnLeft();
				robot.turnLeft();
			}
			robot.turnRight(); // because our directions array is set this way
		}
	}

	public void cleanRoom(Robot robot) {
		Set<Pair> set = new HashSet<>();
		dfs(robot, set, 0, 0, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
