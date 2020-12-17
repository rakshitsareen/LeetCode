package com.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	class Ship {
		Position topLeft;
		Position bottomRight;

		public Ship(Position topLeft, Position bottomRight) {
			this.topLeft = topLeft;
			this.bottomRight = bottomRight;
		}

		public int getHitsOnMe(List<Position> allHits) {
			Iterator<Position> itr = allHits.iterator();
			int i = 0;
			while (itr.hasNext()) {
				Position hit = itr.next();
				if (hit.compareIfGreater(this.topLeft) && this.bottomRight.compareIfGreater(hit))
					i++;
			}
			return i;
		}

		public int myArea() {
			return (Math.abs(topLeft.x - bottomRight.x) + 1) * (Math.abs(topLeft.y - bottomRight.y) + 1);
		}
	}

	class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean compareIfGreater(Position temp) {
            return this.x >= temp.x && this.y >= temp.y;
		}
	}

	public List<Position> prepareHits(String T) {
		StringTokenizer hits = new StringTokenizer(T, " ");
		List<Position> hitPositions = new LinkedList<>();
		while (hits.hasMoreTokens()) {
			String hit = hits.nextToken();
			int lenOfHit = hit.length();
			int x = hit.charAt(lenOfHit - 1) - 'A';
			int y = Integer.parseInt(hit.substring(0, lenOfHit - 1));
			hitPositions.add(new Position(x, y));
		}
		return hitPositions;
	}

	public List<Ship> prepareShips(String S) {
		StringTokenizer ships = new StringTokenizer(S, ",");
		List<Ship> allShips = new LinkedList<>();
		while (ships.hasMoreTokens()) {
			String tempShip = ships.nextToken();
			StringTokenizer shipPoints = new StringTokenizer(tempShip, " ");
			String topLeft = null, bottomRight = null;
			if (shipPoints.hasMoreTokens())
				topLeft = shipPoints.nextToken();
			if (shipPoints.hasMoreTokens())
				bottomRight = shipPoints.nextToken();
			int lenOfHit = topLeft.length();
			int xLeft = topLeft.charAt(lenOfHit - 1) - 'A';
			int yLeft = Integer.parseInt(topLeft.substring(0, lenOfHit - 1));
			lenOfHit = bottomRight.length();
			int xBottom = bottomRight.charAt(lenOfHit - 1) - 'A';
			int yBottom = Integer.parseInt(bottomRight.substring(0, lenOfHit - 1));
			Ship finalShip = new Ship(new Position(xLeft, yLeft), new Position(xBottom, yBottom));
			allShips.add(finalShip);
		}
		return allShips;
	}

	public String solution(int N, String S, String T) {
		List<Position> allHits = prepareHits(T);
		List<Ship> allShips = prepareShips(S);
		Iterator<Ship> itr = allShips.iterator();
		int drowned = 0;
		int mayday = 0;
		while (itr.hasNext()) {
			Ship myShip = itr.next();
			int noOfHitIBraced = myShip.getHitsOnMe(allHits);
			if (noOfHitIBraced > 0) {
				int area = myShip.myArea();
				if (noOfHitIBraced >= area) {
					drowned++;
				} else {
					mayday++;
				}
			}
		}
		return drowned + "," + mayday;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
		System.out.println(sol.solution(12, "1A 2A,12A 12A", "12A"));
	}
}
