package com.apn.alg;

import com.apn.ds.Node;

public class BtTraversalRecursive {

	
	
	public static <T> void preOrder(Node<T> node, Visitor<T> visitor) {
		if(node == null) return;
		
		visitor.visit(node);
		preOrder(node.left, visitor);
		preOrder(node.right, visitor);
	}
	
	public static <T> void postOrder(Node<T> node, Visitor<T> visitor) {
		if(node == null) return;
		
		postOrder(node.left, visitor);
		postOrder(node.right, visitor);
		visitor.visit(node);
	}
	
	public static <T> void inOrder(Node<T> node, Visitor<T> visitor) {
		if(node == null) return;
		
		inOrder(node.left, visitor);
		visitor.visit(node);
		inOrder(node.right, visitor);
	}
	
}
