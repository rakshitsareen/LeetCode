package com.leetcode;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {

	int get(int index);

	int length();
}

public class FindinMountainArray {

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int l = 0, r = mountainArr.length() - 1, peak = 0, m = 0;
		while (l < r) {
			m = (l + r) / 2;
			if (mountainArr.get(m) < mountainArr.get(m + 1)) {
				l = m + 1;
				peak = m + 1;
			} else
				r = m;
		}
		l = 0;
		r = peak;
		while (l <= r) {
			m = (l + r) / 2;
			if (mountainArr.get(m) < target)
				l = m + 1;
			else if (mountainArr.get(m) > target)
				r = m - 1;
			else
				return m;
		}

		l = peak;
		r = mountainArr.length() - 1;
		while (l <= r) {
			m = (l + r) / 2;
			if (mountainArr.get(m) > target)
				l = m + 1;
			else if (mountainArr.get(m) < target)
				r = m - 1;
			else
				return m;
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
