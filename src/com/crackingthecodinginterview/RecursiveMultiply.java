package com.crackingthecodinginterview;

public class RecursiveMultiply {

	public int recMul(int a,int b) {
		if(b==1) return a;
		return a + recMul(a, b-1);
	}
	
	public static void main(String[] args) {
		RecursiveMultiply sol = new RecursiveMultiply();
		System.out.println(sol.recMul(10, 100));
	}
}
