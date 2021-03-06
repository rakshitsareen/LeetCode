package com.leetcode;

class Interval {
	int start;
	int end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
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
		Interval other = (Interval) obj;
		if (end != other.end)
			return false;
		return start == other.start;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
}
