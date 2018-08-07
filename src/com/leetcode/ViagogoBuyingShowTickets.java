package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViagogoBuyingShowTickets {

	public int solution(int[] tickets, int p) {
		int tp = 0;
		int ticketsP = tickets[p];
		for (int i = 0; i < tickets.length; i++) {
			tp += Math.min(tickets[i], ticketsP - (i > p ? 1 : 0));
		}
		return tp;
	}

	public Long solutionQ(int[] tickets, int p) {
		Long count = 0L;
		List<Integer> list = new ArrayList(Arrays.asList(tickets));
		for (int i = 1; i < tickets.length; i++) {
			list.add(tickets[i]);
		}

		final int size = list.size();
		boolean done = false;

		while (!done) {
			for (int j = 1; j < size; j++) {
				if (list.get(j) == 0) {
					continue;
				}
				if (list.get(p + 1) == 0) {
					done = true;
					break;
				}
				list.set(j, list.get(j) - 1);
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		ViagogoBuyingShowTickets sol = new ViagogoBuyingShowTickets();
		int[] tickets = { 4, 5, 5, 2, 3};
		System.out.println(sol.solution(tickets, 3));
	}
}
