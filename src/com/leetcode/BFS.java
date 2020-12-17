package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {
	
	class Graph {
		private int v; // no of vertices

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}

		private List<Integer>[] adj; // Adjacency lists.

		public List<Integer>[] getAdj() {
			return adj;
		}

		public void setAdj(List<Integer>[] adj) {
			this.adj = adj;
		}

		@SuppressWarnings("unchecked")
		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int v, int w) {
			if (adj[v] != null)
				adj[v].add(w);
		}
	}

	private Graph graph = new Graph(4);
	private List<Integer>[] adj;

	public void breadthFirstTraversal(Graph graph, int source) {
		if (graph == null) {
			System.out.println("Empty graph.");
			return;
		}
		this.graph = graph;
		this.adj = this.graph.getAdj();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.getV()];

		visited[source] = true;
		queue.add(source);
		int temp;
		while(!queue.isEmpty()){
			temp = queue.poll();
			System.out.println(temp);
			
			Iterator<Integer> itr = adj[temp].listIterator();
			while(itr.hasNext()){
				int n = itr.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {

		
		//g.addEdge(3, 1);
		BFS sol = new BFS();
		sol.graph.addEdge(0, 1);
		sol.graph.addEdge(0, 2);
		sol.graph.addEdge(1, 2);
		sol.graph.addEdge(2, 0);
		sol.graph.addEdge(2, 3);
		sol.graph.addEdge(3, 3);
		sol.breadthFirstTraversal(sol.graph, 3);
	}
}