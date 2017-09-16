package com.crackingthecodinginterview;

import java.util.LinkedList;

class Graph {
	public Node[] nodes;
}

class Node {
	public int name;
	public Node[] children;
	State state;
}

enum State {
	VISITING, VISITED, UNVISITED
};

public class RouteBetweenNodes {

	public boolean routeBetweenNodes(Graph g, Node startNode, Node destNode) {
		// implement classic BFS
		if (startNode == destNode)
			return true;

		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u : g.nodes) {
			u.state = State.UNVISITED;
		}

		startNode.state = State.VISITING;
		q.add(startNode);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // deque;
			if (u.children != null)
				for (Node v : u.children) {
					if (v.state == State.UNVISITED) {
						if (v == destNode)
							return true;
						else {
							v.state = State.VISITING;
							q.add(v);
						}
					}
				}
			u.state = State.VISITED;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();

		Node node1 = new Node();
		node1.name = 0;

		Node node2 = new Node();
		node2.name = 1;
		Node node3, node4, node5, node6;
		node3 = new Node();
		node3.name = 2;
		node4 = new Node();
		node4.name = 3;
		node5 = new Node();
		node5.name = 5;
		node6 = new Node();
		node6.name = 6;

		Node[] allNodes = { node1, node2, node3, node4, node5, node6 };
		g.nodes = allNodes;

		// linking all the nodes.
		node1.children = new Node[3];
		node1.children[0] = node2;
		node1.children[1] = node5;
		node1.children[2] = node6;

		node2.children = new Node[2];
		node2.children[0] = node4;
		node2.children[1] = node5;

		node3.children = new Node[1];
		node3.children[0] = node2;

		node4.children = new Node[2];
		node4.children[0] = node3;
		node4.children[1] = node5;

		RouteBetweenNodes sol = new RouteBetweenNodes();
		System.out.println(sol.routeBetweenNodes(g, node3, node6));
		System.out.println(sol.routeBetweenNodes(g, node1, node3));

	}

}
