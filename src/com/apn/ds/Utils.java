package com.apn.ds;

import com.apn.alg.Visitor;

public class Utils {

	
	
	
	public static Node<String> buildBinaryTree(){
		Node<String> nodeA = new Node<>("A");
		Node<String> nodeB = nodeA.left = new Node<>("B");
		Node<String> nodeC = nodeA.right = new Node<>("C");
		Node<String> nodeD = nodeB.left = new Node<>("D");
		Node<String> nodeE = nodeB.right = new Node<>("E");
		Node<String> nodeF = nodeC.right = new Node<>("F");
		Node<String> nodeG = nodeE.left = new Node<>("G");
		
		return nodeA;
	}
	
	public static <T> Visitor<T> buildPrintVisitor(){
		
		return new Visitor<T>() {

			@Override
			public void visit(Node<T> node) {
				System.out.print(node.value);
			}			
		};
		
		
	}
	
}
