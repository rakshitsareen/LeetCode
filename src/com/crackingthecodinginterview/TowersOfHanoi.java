package com.crackingthecodinginterview;

public class TowersOfHanoi {

	public static void towersOfHanoi(int nDisks, char from, char to, char aux) {
		if (nDisks == 1) {
			System.out.println("Move disk 1 from rod " + from + " to rod " + to);
			return;
		}
		
		else {
			towersOfHanoi(nDisks-1, from, aux, to);
			System.out.println("Move disk "+nDisks+" from rod " + from + " to rod " + to);
			towersOfHanoi(nDisks-1, aux, to, from);
			return;
		}
	}
	
//	public static towersOfHanoiIter(int nDisks) {
//		
//	}

	public static void main(String[] args) {
		int n = 4; // Number of disks
		towersOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
	}

}
