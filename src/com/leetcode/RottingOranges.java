package com.leetcode;


public class RottingOranges {

	static class Pair {
		Integer x;
		Integer y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int orangesRotting(int[][] grid) {
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
