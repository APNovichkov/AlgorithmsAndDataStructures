package com.apn.ds;

/**
 * 
 * @author apnovichkov
 *
 * Start time: 9:15
 * End time:   9:23
 *
 */



public class Queue {


	static class Node {
		int value;
		Node next;
		
		
		public Node(int value) {
			this.value = value;
		}
	}	
	
	private Node start;
	private Node end;
	
	public boolean isEmpty() {
		return start == null;
	} 
	
	public void add(int value) {
		Node node = new Node(value);
		if(isEmpty()) {
			start = node;
			end = node;
		}else{
			end.next = node;
			end = node;
		}
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");
		return start.value;
	}
	
	public int poll() {
		int value = peek();
		if(start == end) {
			start = null;
			end = null;
		}else {
			start = start.next;
		}
		return value;
	}
	
}
