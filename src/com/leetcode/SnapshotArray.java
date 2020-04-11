package com.leetcode;

import java.util.TreeMap;

public class SnapshotArray {

	int snap_id;
	TreeMap<Integer, Integer>[] arr;

	public SnapshotArray(int length) {
		arr = new TreeMap[length];
		for (int i = 0; i < length; ++i) {
			arr[i] = new TreeMap<>();
			arr[i].put(0, 0);
		}
	}

	public void set(int index, int val) {
		arr[index].put(snap_id, val);
	}

	public int snap() {
		snap_id++;
		return snap_id - 1;
	}

	public int get(int index, int snap_id) {
		return arr[index].floorEntry(snap_id).getValue();
	}

}
