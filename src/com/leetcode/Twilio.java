package com.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Twilio {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		String filename;
		filename = "inp.txt";
		// Your code here
		Map<String, Integer> map = new HashMap<>();
		File file = new File(filename);
		// System.out.println("Attempting to read from file in:
		// "+file.getCanonicalPath());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[] hostarr;
		String host;
		while ((line = br.readLine()) != null) {
			// System.out.println(line);
			hostarr = line.split("\\s+");
			host = hostarr[0];
			// System.out.println(host);
			if (map.containsKey(null)) {
			}
			if (!map.containsKey(host)) {
				map.put(host, 1);
			}
			else if (map.containsKey(host)) {
				Integer c = map.get(host);
				map.put(host, c + 1);
			}
		}
		br.close();
		for (String e : map.keySet()) {
			System.out.println(e + " " + map.get(e));
		}
	}
}