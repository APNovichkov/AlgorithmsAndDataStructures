package com.apn.ds;

public class UnionFind {

	HashMap<Integer, Integer> nodes;
	int[] disjointSet;
	
	
	public UnionFind(int[] nodes) {
		for(int i = 0; i < nodes.length; i++) {
			this.nodes.put(nodes[i], i);
			disjointSet[i] = i;
		}
	}
	
	//what should find do? 
	public int find(int node) {
		
	}
	
	public void union(int node1, int node2) {
		while(true) {
			if(node1 == nodes.get(node1) && node2 == nodes.get(node2)) {
				disjointSet[node2] = node1;
				break;
			}
		}
	}
	
}
