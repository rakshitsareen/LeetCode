package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		List<Object> mylist = new ArrayList<>();
		mylist.add(mylist);
		mylist.add(1);
		mylist.add("Java");
		System.out.println(mylist);
		/*
		 * output = [(this Collection), 1, Java], equivalent to python list
		 */
	}

}
