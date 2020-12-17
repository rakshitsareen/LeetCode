package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser,
			int minLikeThreshold) {
		int[] a = new int[0];
		if (followGraph_edges == null)
			return a;
		if (followGraph_edges.length < 1)
			return a;
		if (likeGraph_edges == null)
			return a;
		if (likeGraph_edges.length < 1)
			return a;
		if (minLikeThreshold < 0)
			return a;

		Set<Integer> followsSet = new HashSet<>();
		Map<Integer, Integer> likeCountByFollowers = new TreeMap<>();
		int rows_follow_graph = followGraph_edges.length;
		int rows_like_graph = likeGraph_edges.length;

		// populate the follows set.
		for (int i = 0; i < rows_follow_graph; i++)
			if (followGraph_edges[i][0] == targetUser) {
				if (followGraph_edges[i][1] != targetUser)
					followsSet.add(followGraph_edges[i][1]);
			}

		/*
		 * for all the edges, check if a followee has liked a tweet. increment the
		 * tweets count in the hashmap.
		 */

		for (int i = 0; i < rows_like_graph; i++) {
			int userID = likeGraph_edges[i][0];
			int tweetID = likeGraph_edges[i][1];
			if (userID != targetUser) {
				if (followsSet.contains(userID)) {
					if (likeCountByFollowers.get(tweetID) != null) {
						int count = likeCountByFollowers.get(tweetID);
						count++;
						likeCountByFollowers.put(tweetID, count);
					} else {
						likeCountByFollowers.put(tweetID, 1);
					}
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		Iterator<Map.Entry<Integer, Integer>> itr = likeCountByFollowers.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Integer> pair = itr.next();
			if (pair.getValue() >= minLikeThreshold) {
				ans.add(pair.getKey());
			}
		}

		if (ans.size() > 0) {
			int n = ans.size();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = ans.get(i);
			}
		}
		
		return a;
	}

	public static int krakenCount(int m, int n) {
		int[][] ans = new int[m][n];
		// initialize the data.
		for (int i = 0; i < n; i++)
			ans[0][i] = 1;
		for (int i = 0; i < m; i++)
			ans[i][0] = 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1] + ans[i][j - 1];
		return ans[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// System.out.println(Solution.krakenCount(2, 3));
		//int[][] a = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 5, 6 } };
		int[][] a = { };
		int[][] b = { { 2, 10 }, { 3, 10 }, { 4, 10 }, { 2, 11 }, { 3, 12 }, { 4, 11 } };
		// int[][] b = { { 1, 10 }, { 2, 10 }, { 3, 10 }, { 55, 11 }, { 45, 12 }, { 12,
		// 11 } };
		int[] ans = Solution.getRecommendedTweets(a, b, 1, 0);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

}
