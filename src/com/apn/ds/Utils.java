package com.apn.ds;

import java.util.Vector;

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
			Vector<T> sequence = new Vector<>();
			
			@Override
			public void visit(Node<T> node) {
				sequence.add(node.value);
				System.out.print(node.value);
			}			
			
			@Override
			public String toString() {
				StringBuilder s = new StringBuilder();
				
				for(T value: sequence) {
					s.append(value.toString());
				}
				
				return s.toString();
			}
		};
		
		
	}
	
}
