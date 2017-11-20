package com.leetcode;

public class GraphAlgorithms {

	static int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	static void union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	static boolean isCycle(Graph g) {
		int parent[] = new int[g.V];
		for (int i = 0; i < g.V; i++)
			parent[i] = -1;

		for (int i = 0; i < g.E; i++) {
			int x = find(parent, g.edge[i].src);
			int y = find(parent, g.edge[i].dest);
			if (x == y)
				return true;
			union(parent, x, y);
		}
		return false;
	}

	public static void main(String[] args) {
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (isCycle(graph))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Cycle free graph");
	}

}
