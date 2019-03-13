package com.apn.ds;

/**
 * 
 * @author apnovichkov
 *
 * Start time: 2:15
 * End time:   3:24
 *
 * @param <V>
 */

public class LinkedList<V> {

	class Node{
		V value;
		Node next;
		Node prev;
		
		Node(V value){
			this.value = value;
		}
	};
	
	
	class ForwardIterator implements Iterator<V>{
		private Node node;
		
		ForwardIterator() {
			node = start;
		}
		
		@Override
		public boolean hasNext() {
			return node == null;
		}

		@Override
		public V next() {
			V value = node.value;
			node = node.next;
			return value;
		}
		
	};
	
	class ReverseIterator implements Iterator<V>{
		private Node node;
		
		ReverseIterator() {
			node = end;
		}
		
		@Override
		public boolean hasNext() {
			return node == null;
		}

		@Override
		public V next() {
			V value = node.value;
			node = node.prev;
			return value;
		}
		
	};
	
	
	private Node start;
	private Node end;
	
	private int size = 0;
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public V peekFirst() {
		if(isEmpty()) throw new RuntimeException("Linked list is empty");
		return start.value;
	}
	
	public V peekLast() {
		if(isEmpty()) throw new RuntimeException("Linked list is empty");
		return end.value;
	}
	
	
	public V removeFirst() {
		V value = peekFirst();
		start = start.next;
		start.prev = null;
		size--;
		return value;
	}
	
	public V removeLast() {
		V value = peekLast();
		end = end.prev;
		end.next = null;
		size--;
		return value;
	}
	
	
	
	public void addFirst(V value) {
		Node node = new Node(value);
		node.next = start;
		start.prev = node;
		start = node;
		size++;
	}
	
	public void addLast(V value) {
		Node node = new Node(value);
		end.next = node;
		node.prev = end;
		end = node;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<V> iterator(){
		return new ForwardIterator();
	}
	
	public Iterator<V> reverseIterator(){
		return new ReverseIterator();
	}
	
	public void insert(int index, V value) {
		if(index > size || index < 0) {
			throw new RuntimeException("Index out of bounds");
		}else if(size == 0 || index == 0) {
			addFirst(value);
		}else if(index == size){ 
			addLast(value);
		}else {
			Node newNode = new Node(value);
			Node nodeAtIndex = getNodeByIndex(index);
			
			newNode.next = nodeAtIndex;
			newNode.prev = nodeAtIndex.prev;
			nodeAtIndex.prev.next = newNode;
			nodeAtIndex.prev = newNode;
		}  
	}
	
	public V remove(int index) {
		V value;
		
		if(index > size || index < 0) {
			throw new RuntimeException("Index out of bounds");
		}else if(size == 1 || index == 0) {
			value = removeFirst();
		}else if(index == size){ 
			value = removeLast();
		}else {
			Node nodeAtIndex = getNodeByIndex(index);
			nodeAtIndex.prev.next = nodeAtIndex.next;
			nodeAtIndex.next.prev = nodeAtIndex.prev;
			value = nodeAtIndex.value;
		}  
		
		
		return value;
	}
	
	public V remove(V value) {
		int index = getIndexByValue(value);
		return remove(index);		
	}
	
	public LinkedList<V> reverse() {				
		LinkedList<V> list = new LinkedList<>();
		Iterator<V> reverseIterator = reverseIterator();
		
		while(reverseIterator.hasNext()) {
			list.addLast(reverseIterator.next());
		}
		
		return list;
	}
	
	private Node getNodeByIndex(int index) {
		Node node = start;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	private int getIndexByValue(V value) {
		int index;
		Node node = start;
		for(index = 0; index < size; index++) {
			if(node.value == value) break;
			node = node.next;
		}
		
		return index;
	}
	
	public boolean contains(V value) {
		boolean contains = false;
		
		for(Node node = start; node.next != null; node = node.next) {
			if(node.value == value) {
				contains = true;
				break;
			} 
		}
		
		return contains;
	}
	
	
	
}
