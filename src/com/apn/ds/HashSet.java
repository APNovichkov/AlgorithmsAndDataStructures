package com.apn.ds;



public class HashSet<T> {
	
	static class Node<T>{
		T value;
		Node<T> next;
		Node(T value){
			this.value = value;
		}
		
		
	}
	
	final int CAPACITY = 10;
	Node<T>[] buckets;
	
	class SetIterator implements Iterator<T>{
		int cIndex = 0;
		Node<T> cNode = null;
		
		SetIterator() {
			tryFindNext();
		}
		
		@Override
		public boolean hasNext() {
			return cNode != null;
		}

		@Override
		public T next() {
			if(cNode == null) throw new RuntimeException("End of iterator");
			
			Node<T> node = cNode;
			tryFindNext();
			return node.value;
		}
		private void tryFindNext() {			
			// one step forward
			if(cNode != null) {
				cNode = cNode.next;
			}
			
			// Search if NEEDED
			for( ; cNode == null && cIndex < CAPACITY; cIndex++ ) {
				cNode = buckets[cIndex];
			}
		}		
	};
	
	
	@SuppressWarnings("unchecked")
	public HashSet() {
		buckets = new Node[CAPACITY];
	}
	
	public void add(T value) {
		if(contains(value)) return;
		
		Node<T> node  = new Node<T>(value);
		int index = bucketIndex(value);
		
		node.next = buckets[index];
		buckets[index] = node;		
	}
	
	public T remove(T value) {
	
		int index = bucketIndex(value);
		
		Node<T> pNode = null;		
		Node<T> node = buckets[index];
		while(node != null){
			if(node.value == value) {
				break;
			}
			pNode = node;
			node = node.next;			
		}
		
		if(node != null) {
			if(pNode == null) {
				buckets[index] = node.next;
			} else {
				pNode = node.next;
			}
		}
		
		return node != null ? node.value : null; 
	}
	
	public boolean contains(T value) {
		int index = bucketIndex(value);
		return findNode(index, value) != null;		
	}

	private Node<T> findNode(int bucketIndex, T value){
		Node<T> node = buckets[bucketIndex];
		while(node != null){
			if(node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	private int bucketIndex(T value) {
		if(value == null) throw new RuntimeException("You are trying to add a null value");
		return value.hashCode()%CAPACITY;
	}
	
	public Iterator<T> iterator(){
		return new SetIterator();
	}
	
	
	//DID THIS 3/12
	public int size() {
		int size = 0;
		SetIterator iterator = new SetIterator();
		while(iterator.hasNext()) {
			size++;
			iterator.next();
		}
		return size;
	}	
	
}
