package com.apn.ds;

public class Node<T> {
	public T value;
	public Node<T> right;
	public Node<T> left;
	
	public Node(T value) {
		this.value = value;
	}
}
