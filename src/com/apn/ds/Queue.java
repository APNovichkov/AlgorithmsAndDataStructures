package com.apn.ds;

/**
 * 
 * @author apnovichkov
 *
 * Start time: 9:15
 * End time:   9:23
 *
 */



public class Queue<T> {


	static class Node<T> {
		T value;
		Node<T> next;
		
		
		public Node(T value) {
			this.value = value;
		}
	}	
	
	private Node<T> start;
	private Node<T> end;
	
	public boolean isEmpty() {
		return start == null;
	} 
	
	public void add(T value) {
		Node<T> node = new Node<T>(value);
		if(isEmpty()) {
			start = node;
			end = node;
		}else{
			end.next = node;
			end = node;
		}
	}
	
	public T peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");
		return start.value;
	}
	
	public T poll() {
		T value = peek();
		if(start == end) {
			start = null;
			end = null;
		}else {
			start = start.next;
		}
		return value;
	}
	
}
