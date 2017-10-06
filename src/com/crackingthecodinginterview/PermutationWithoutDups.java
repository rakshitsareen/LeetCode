package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Iterator;

public class PermutationWithoutDups {

	public static ArrayList<String> generatePermutationsWitDups(String s, ArrayList<String> list) {
		if (s == null || s.length() == 0)
			return list;
		if (s.length() == 1) {
			list.add(s);
			return list;
		} else {
			// remove head and generate all perms
			char head = s.charAt(0);
			// now stitch this head in all positions of all these permutation and add to
			// list using iterator.
			String snew =new String(s.substring(1, s.length()));
			generatePermutationsWitDups(snew, list);
			// here list will contain all the permutations of the remaining string.
			Iterator<String> itr = list.iterator();
			ArrayList<String> nList = new ArrayList<>();
			while (itr.hasNext()) {
				String val = itr.next();
				itr.remove();
				int len = val.length();
				int i = 0;
				while (i < len+1) {
					String nval =  val.substring(0, i) + head + val.substring(i, val.length()); 
					nList.add(nval);
					i++;
				}
			}
			list.addAll(nList);
			nList = null;
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		String s = new String("xyz");
		ArrayList<String> nList = PermutationWithoutDups.generatePermutationsWitDups(s, list);
		for(String stemp : nList) {
			System.out.println(stemp);
		}
	}
}
