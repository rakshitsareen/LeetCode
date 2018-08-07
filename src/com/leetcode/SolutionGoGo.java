package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class Buyer {
	int x;
	int y;

	public Buyer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Event implements Comparable<Event> {
	Integer id;
	Integer x;
	Integer y;
	Integer prices;

	public Event(int id, int x, int y, int price) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.prices = price;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Event) {
			Event _o = (Event) o;
			if ((_o.x == this.x) && _o.y == this.y && _o.id == this.id && this.prices == _o.prices) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Event o) {
		if (this == o) {
			return 0;
		}
		if (o instanceof Event) {
			Event _o = (Event) o;
			if ((_o.x == this.x) && _o.y == this.y && _o.id == this.id && this.prices == _o.prices) {
				return 0;
			}
			if (this.prices < _o.prices)
				return -1;
			if (this.prices > _o.prices)
				return 1;
			if (this.id < _o.id)
				return -1;
			else
				return 1;
		}
		return -1;
	}

}

public class SolutionGoGo {

	public static Event getClosestEvent(Buyer b, List<Event> elist) {
		TreeMap<Integer, TreeSet<Event>> col = new TreeMap<>();
		int bx = b.x;
		int by = b.y;
		for (Event e : elist) {
			int ex = e.x;
			int ey = e.y;
			int dist = calculateManhattanDistance(bx, by, ex, ey);
			if (col.get(dist) != null) {
				col.get(dist).add(e);
			} else {
				TreeSet<Event> set = new TreeSet<>();
				set.add(e);
				col.put(dist, set);
			}
		}
		return col.get(col.firstKey()).first();
	}

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scan = new Scanner(System.in);
		List<Event> elist = new ArrayList<>();
		List<Buyer> blist = new ArrayList<>();
		int sizeOfWorld = Integer.parseInt(scan.nextLine());
		int numberOfEvents = Integer.parseInt(scan.nextLine());

		while (numberOfEvents > 0) {
			String eventLine = scan.nextLine();
			String[] arr = eventLine.split(" ");
			int id = Integer.parseInt(arr[0]);
			int x = Integer.parseInt(arr[1]);
			int y = Integer.parseInt(arr[2]);
			int remainingLen = arr.length - 3;
			if (remainingLen > 0) {
				int price = 0;
				for (int i = 1; i <= remainingLen; i++) {
					price = Integer.parseInt(arr[i+2]);
					Event e = new Event(id, x, y, price);
					elist.add(e);
				}
			}
			numberOfEvents--;
		}

		int numberOfBuyers = Integer.parseInt(scan.nextLine());
		while (numberOfBuyers > 0) {
			String buyerLine = scan.nextLine();
			String[] arr = buyerLine.split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			Buyer b = new Buyer(x, y);
			blist.add(b);
			numberOfBuyers--;
		}

		// The solution to the first sample above would be to output the following to
		// console:
		// (Obviously, your solution will need to figure out the output and not just
		// hard code it)

		for (Buyer b : blist) {
			Event e = SolutionGoGo.getClosestEvent(b, elist);
			elist.remove(e);
			System.out.println(e.id + " " + e.prices);
		}

	}

	public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}