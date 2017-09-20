package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

class Graph {
	int V;// No. of vertices

	// An Array of List which contains
	// references to the Adjacency List of
	// each vertex
	List<Integer> adj[];

	public Graph(int V)// Constructor
	{
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	// function to add an edge to graph
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
}

public class BuildOrder {

	public void buildOrder(Graph g) { // Create a array to store indegrees of all
		// vertices. Initialize all indegrees as 0.
		int indegree[] = new int[g.V];

		// Traverse adjacency lists to fill indegrees of
		// vertices. This step takes O(V+E) time
		for (int i = 0; i < g.V; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) g.adj[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}
//		for (int i = 0; i < g.V; i++) {
//			System.out.println(indegree[i]);
//		}

		// Create a queue and enqueue all vertices with
		// indegree 0
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < g.V; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		// Initialize count of visited vertices
		int cnt = 0;

		// Create a vector to store result (A topological
		// ordering of the vertices)
		Vector<Integer> topOrder = new Vector<Integer>();
		while (!q.isEmpty()) {
			// Extract front of queue (or perform dequeue)
			// and add it to topological order
			int u = q.poll();
			topOrder.add(u);

			// Iterate through all its neighbouring nodes
			// of dequeued node u and decrease their in-degree
			// by 1
			for (int node : g.adj[u]) {
				// If in-degree becomes zero, add it to queue
				if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

		// Check if there was a cycle
		if (cnt != g.V) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		// Print topological order
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		// g.addEdge(5, 2);
		// g.addEdge(5, 0);
		// g.addEdge(4, 0);
		// g.addEdge(4, 1);
		// g.addEdge(2, 3);
		// g.addEdge(3, 1);

		BuildOrder sol = new BuildOrder();
		g.addEdge(5, 0);
		g.addEdge(5, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(3, 2);

		sol.buildOrder(g);
	}

}
