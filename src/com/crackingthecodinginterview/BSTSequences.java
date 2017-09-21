package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {

	public ArrayList<LinkedList<Integer>> generateSequences(TreeNode root) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
		if (root == null) {
			result.add(new LinkedList<>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(root.value);

		ArrayList<LinkedList<Integer>> left = generateSequences(root.left);
		ArrayList<LinkedList<Integer>> right = generateSequences(root.right);

		// start weaving the lists together.

		for (LinkedList<Integer> leftseq : left)
			for (LinkedList<Integer> rightseq : right) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
				weaveLists(leftseq, rightseq, weaved, prefix);
				result.addAll(weaved);
			}
		return result;
	}

	public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);

	}

	public static void main(String[] args) {
		// TODO Write Test Code.
		TreeNode root1 = new TreeNode(5);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(4);
		// root1.left.left.right = new BinaryTreeNode(2);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(8);
		
		BSTSequences sol = new BSTSequences();
		ArrayList<LinkedList<Integer>> result = sol.generateSequences(root1);

		for (LinkedList<Integer> line : result) {
			for (Integer num : line) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}
