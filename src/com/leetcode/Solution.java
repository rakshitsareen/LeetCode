package com.leetcode;

import java.util.Iterator;
import java.util.Random;

class MyRandom implements Iterator<Integer> {

	private Integer life = 5;

	@Override
	public boolean hasNext() {
        return life > 0;
    }

	@Override
	public Integer next() {
		try {
			if (life > 0) {
				Random r = new Random();
				life--;
				return r.nextInt();
			}
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Cannot produce more randomness");
			return null;
		}
	}
}

public class Solution {

	public static void main(String[] args) {

		MyRandom random = new MyRandom();
		while (random.hasNext()) {
			System.out.println(random.next());
		}
	}

}
