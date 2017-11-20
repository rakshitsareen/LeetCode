package com.leetcode;

public class Graph {
	
	public int V, E;
	Edge edge[];

	class Edge {
		int src, dest;
	};

	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

