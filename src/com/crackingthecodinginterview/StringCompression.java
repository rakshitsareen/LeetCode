package com.crackingthecodinginterview;

public class StringCompression {
	
	//Uses extra space.
	public String compressString(String s) {
		int consecutiveOccurences = 0;
		StringBuilder compressed = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			consecutiveOccurences++;
			if (i+1 >= s.length() || s.charAt(i + 1) != s.charAt(i)) {
				// dump the string
				compressed.append(s.charAt(i)).append(String.valueOf(consecutiveOccurences));
				consecutiveOccurences = 0;
			}
		}
		return compressed.length() < s.length() ? compressed.toString() : s;
	}
	
	//with no extra space if output string's length is guaranteed to be smaller than original string's length
	//this will take two pointer approach.
	public String compressStringNoSpace(String s){
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char last = s.charAt(0);
		for(int i =0 ; i<s.length();i++){
			if(s.charAt(i) == last){
				count++;
			}
			else { //flush the string
				sb.append(last).append(count);
				count = 1;
			}
			last = s.charAt(i);
		}
		sb.append(last).append(count);
		
		return sb.length() < s.length() ? sb.toString() : s;
	}

	public static void main(String[] args) {
		StringCompression sol = new StringCompression();
		System.out.println(sol.compressString("aaaabbbbccccd"));
		System.out.println(sol.compressString("abcdddd"));
		return;
	}
}
