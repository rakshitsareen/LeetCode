package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {

	private static Map<Integer, List<Integer>> generateMap(List<Integer> pid, List<Integer> ppid) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++) {
			int child = pid.get(i);
			if (map.get(ppid.get(i)) == null) {
				List<Integer> l = new ArrayList<>();
				l.add(child);
				map.put(ppid.get(i), l);
			} else
				map.get(ppid.get(i)).add(child);
		}
		return map;
	}

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> map = generateMap(pid, ppid);
		if (map.get(kill) == null) {
			List<Integer> l = new ArrayList<>();
			l.add(kill);
			return l;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		int process_to_kill = kill;
		List<Integer> output = new ArrayList<>();
		while (!q.isEmpty()) {
			process_to_kill = q.poll();
			if (map.get(process_to_kill) != null)
				q.addAll(map.get(process_to_kill));
			output.add(process_to_kill);
		}
		return output;
	}

	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(2);
		pid.add(3);
		List<Integer> ppid = new ArrayList<>();
		ppid.add(0);
		ppid.add(1);
		ppid.add(2);
		System.out.println(killProcess(pid, ppid, 1));
	}

}
