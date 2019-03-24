package com.apn.ds;

import com.apn.ds.Queue.Node;

/**
 * Start 10:20
 * End   10:40
 * @author apnovichkov
 *
 */

public class Stack {
	

	static class Node {
		int value;
		Node next;
		
		
		public Node(int value) {
			this.value = value;
		}
	}		
	
	private Node top;
	
	boolean isEmpty() {
		return top == null;
	}
	
	int peek() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return top.value;
	}
	
	void push(int value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
	}
	
	int pop() {
		int value = peek();
		top = top.next;
		return value;
	}
	
}
