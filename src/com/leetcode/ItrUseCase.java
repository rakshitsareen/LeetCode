package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// how to use an Iterator, student asked this one
public class ItrUseCase {

	private List<Integer> mlist = null;
	Integer[] a = null;

	public void addAll() {
		mlist = new ArrayList<>();
		mlist.add(1);
		mlist.add(2);
		mlist.add(3);
		mlist.add(4);
	}

//	public MovieList getMatchingTitles(String keyword) {
//		if (keyword == null || keyword.length() == 0)
//			return null;
//		
//		MovieList m = new MovieList();
//		
//		for(Object s : this.elementData) {
//			String stemp = (String)s;
//			if(stemp.contentEquals(keyword)) {
//				m.add(stemp);
//			}
//		}
//		if(m.size() > 0) {
//			return Collections.sort(m);
//		}
//		
//		return null;
//	}

	public void iterate() {

		Integer.parseInt("five");
		Iterator<Integer> xitr = mlist.iterator();
		if (xitr.hasNext())
			System.out.println(xitr.next());
		Iterator<Integer> mitr = mlist.iterator();
		while (mitr.hasNext()) {
			System.out.println(mitr.next());
		}
	}

	public static void main(String[] args) {
		ItrUseCase sol = new ItrUseCase();
		sol.addAll();
		sol.iterate();
	}

}
