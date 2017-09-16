package com.crackingthecodinginterview;

public class Problem1 {
	
	public boolean checkUniqueCharacters(String str){
		if(str == null || str.isEmpty())
			return true;
		int bits = 0;
		int prev = 0;
		for(int i= 0; i<str.length();i++){
			prev = bits;
			bits = (1<<str.charAt(i) - 'a' | bits);
			if(prev == bits)
				return false;
		}
		return true;
	}
	
	//Implement an algorithm to determine if a string has all unique characters.
	//What if you can not use additional data structures?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem1 sol = new Problem1();
		System.out.println(sol.checkUniqueCharacters("abcdeff"));
		return;
	}

}
/*
Alternatively, we could do the following:
1. Check every char of the string with every other char of the string for duplicate 
occurrences. This will take O(n^2) time and no space.
2. If we are allowed to destroy the input string, we could sort the string in
 O(n log n) time and then linearly check the string for neighboring characters 
 that are identical. Careful, though - many sorting algorithms take up extra space.
*/