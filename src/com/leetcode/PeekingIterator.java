package com.leetcode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {

	private Integer next = null;
	private boolean noSuchElement = false;
	private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		advanceiter();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (noSuchElement)
			throw new NoSuchElementException();
		Integer output = next;
		advanceiter();
		return output;
	}

	@Override
	public boolean hasNext() {
		return !noSuchElement;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void advanceiter() {
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			noSuchElement = true;
		}
	}

}
