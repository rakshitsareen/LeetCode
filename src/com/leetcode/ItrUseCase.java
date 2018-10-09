package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// how to use an Iterator, student asked this one
public class ItrUseCase {

	private List<Integer> mlist = null;

	public void addAll() {
		mlist = new ArrayList<>();
		mlist.add(1);
		mlist.add(2);
		mlist.add(3);
	}

	public void iterate() {
		Iterator<Integer> mitr = mlist.iterator();
		while (mitr.hasNext()) {
			System.out.println(mitr.next());
		}

		for (Integer e : mlist) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		ItrUseCase sol = new ItrUseCase();
		sol.addAll();
		sol.iterate();
	}

}
