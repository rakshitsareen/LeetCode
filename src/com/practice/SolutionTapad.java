package com.practice;

/*
i/p: Array of numbers from 1...n of size n-1. no repetitions.
o/p: missing number

example (1, 4, 5, 2) -> 3
*/

/*
i/p: Sorted array of numbers from 1...n of size n-1. no repetitions.
o/p: missing number

example (1, 2, 4, 5) -> 3

ip:      (1,2,3,4,5,6,  ,8)
          0 1 2 3 4 5    6
correct: (1,2,3,4,5,6,7,8)
          0 1 2 3 4 5 6 7
          
ip:      (1, ,3,4,5,6,7,8)
          0   1 2 3 4 5 6
Criteria : A[i] == i+1 // right spot, then missing is at right side
              if(A[i] - A[i-1] > 1) return A[i] - 1;
              else if(A[i+1] - A[i] > 1)  return A[i] + 1;
           A[i] > i +1 // wrong place. then missing is at left side
O(logn)
`4` is at index 2 -- missing is on left
`4 is at index` 3 missing is on right
*/
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SolutionTapad {

	public static int missingNumber(int[] nums) {
		if (nums == null)
			return -1;
		int n = nums.length;
		// finding sum of first n numbers
		int sum = ((n + 2) * (n + 1)) / 2;

		int sumArr = 0;
		for (int i = 0; i < n; i++) {
			sumArr += nums[i];
		}

		return sum - sumArr;

	}

	public static int missingNumberSorted(int[] A, int start, int end) {
		int n = A.length;
		int mid = (start + end) / 2;
		if (A[mid] == mid + 1) { // right spot, recurse right
			if (A[mid] - A[mid - 1] > 1)
				return A[mid] - 1;
			else if (A[mid + 1] - A[mid] > 1)
				return A[mid] + 1;
			else
				return missingNumberSorted(A, mid + 1, end);
		}

		else { // recurse left
			if (A[mid] - A[mid - 1] > 1)
				return A[mid] - 1;
			else if (A[mid + 1] - A[mid] > 1)
				return A[mid] + 1;
			else {
				return missingNumberSorted(A, start, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * ArrayList<String> strings = new ArrayList<String>();
		 * strings.add("Hello, World!"); strings.add("Welcome to CoderPad.");
		 * strings.add("This pad is running Java 8.");
		 * 
		 * for (String string : strings) { System.out.println(string); }
		 */
		int[] nums = { 1, 2, 4, 5 };
		int number = missingNumberSorted(nums, 0, nums.length);
		System.out.println(number);

	}
}
