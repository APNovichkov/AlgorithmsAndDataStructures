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
	
	//returns the index of the root that is connected to this node. 
	public int find(int nodeIndex) {
		
		if(nodeIndex == disjointSet[nodeIndex]) return nodeIndex;
		
		int rootIndex = find(nodeIndex);
		
		return rootIndex;
	}
	
	public void union(int node1, int node2) {
		int root1 = find(nodes.get(node1));
		int root2 = find(nodes.get(node2));
		
		if (root1 != root2) {
			disjointSet[root2] = root1;
		}else {
			System.out.println("Same root. No need to union");
		}
	}
	
}
