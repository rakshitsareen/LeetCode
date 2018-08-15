package com.leetcode;

public class NumericalBucket {

	public static int calculateAmountOfWater(int[] arr) {
		int output = 0;
		int[] maxFromLeft = new int[arr.length], maxFromRight = new int[arr.length];
		maxFromLeft[0] = arr[0];
		maxFromRight[arr.length - 1] = arr[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxFromLeft[i - 1])
				maxFromLeft[i] = arr[i];
			else
				maxFromLeft[i] = maxFromLeft[i - 1];
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > maxFromRight[i + 1])
				maxFromRight[i] = arr[i];
			else
				maxFromRight[i] = maxFromRight[i + 1];
		}

		// Now we have the max_to_the_right and max_to_the_left for every element.
		// we can calculate the total water it can contain:
		// water_i_can_contain = Math.min(maxFromLeft[i],maxFromRight[i]) - arr[i]
		for (int i = 0; i < arr.length; i++) {
			output += Math.min(maxFromLeft[i], maxFromRight[i]) - arr[i];
		}

		return output;
	}

	public static void main(String[] args) {
		int[] hist = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(NumericalBucket.calculateAmountOfWater(hist));
	}

}
