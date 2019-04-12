package com.apn.ds;

public class BinarySearchTree<T>{

	public class Node<T>{
		Node<T> right;
		Node<T> left;
		
		T value;
	}
	
	
	public T search(T value, Node<T> root) {
		
		Node<T> traversalNode = root;
		
		while(traversalNode.value != value || (traversalNode.left != null && traversalNode.right != null)) {
			if((int)(traversalNode.value) < (int)(value)) {
				traversalNode = traversalNode.left;
			}else{
				traversalNode = traversalNode.right;
			}
		}
		
		return traversalNode.value;
	}
	
}
