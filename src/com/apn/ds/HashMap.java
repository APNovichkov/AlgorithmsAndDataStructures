package com.apn.ds;

import com.apn.ds.HashSet.Node;

public class HashMap<K,V> {
	
	static class Node<K,V> {
		K key;
		V value;
		Node<K,V> next;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	class KeyIterator implements Iterator<K>{
		int cIndex = 0;
		Node<K,V> cNode = null;
		
		KeyIterator() {
			tryFindNext();
		}
		
		@Override
		public boolean hasNext() {
			return cNode != null;
		}

		@Override
		public K next() {
			if(cNode == null) throw new RuntimeException("End of iterator");
			
			Node<K,V> node = cNode;
			tryFindNext();
			return node.key;
			
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
	
	class ValueIterator implements Iterator<V>{
		int cIndex = 0;
		Node<K,V> cNode = null;
		
		ValueIterator() {
			tryFindNext();
		}
		
		@Override
		public boolean hasNext() {
			return cNode != null;
		}

		@Override
		public V next() {
			if(cNode == null) throw new RuntimeException("End of iterator");
			
			Node<K,V> node = cNode;
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
	
	
	
	final int CAPACITY = 1000;
	Node<K, V>[] buckets;
	
	
	@SuppressWarnings("unchecked")
	public HashMap() {
		buckets = new Node[CAPACITY];
	}
	
	
	//TODO
	public int size() {
		int size = 0;
		KeyIterator iterator = new KeyIterator();
		while(iterator.hasNext()) {
			size++;
		}
		return size;
	}
	
	public void put(K key, V value) {
		int index = bucketIndex(key);
		
		if(containsKey(key)) {
			Node<K, V> tmpNode = buckets[index]; 
			while(tmpNode != null) {
				if(tmpNode.key == key) tmpNode.value = value;
			}
		}else {
			Node<K, V> node = new Node<K, V>(key, value);
			node.next = buckets[index];
			buckets[index] = node;
		}
	}
	
	public V get(K key) {
		int index = bucketIndex(key);
		
		if(containsKey(key)) {
			Node<K, V> node = buckets[index]; 
			while(node != null) {
				if(node.key == key) return node.value;
			}
		}
		
		//if there is no key in the hashMap, return null
		return null;
	}
	
	public boolean containsKey(K key) {
		int index = bucketIndex(key);
		
		Node<K, V> node = buckets[index]; 
		while(node != null) {
			if(node.key == key) return true;
		}

		return false;
	}
	
	public V remove(K key) {
		int index = bucketIndex(key);
		
		Node<K,V> pNode = null;		
		Node<K,V> node = buckets[index];
		while(node != null){
			if(node.key == key) {
				break;
			}
			pNode = node;
			node = node.next;			
		}
		
		if(node != null) {
			if(pNode == null) {
				buckets[index] = node.next;
			}else{
				pNode = node.next;
			}
		}
		
		return node != null ? node.value : null; 
	}
	
	public Iterator<K> keys(){
		return new KeyIterator();
	}
	
	public Iterator<V> values(){
		return new ValueItarator();
	}
	
	private int bucketIndex(K key) {
		if(key == null) throw new RuntimeException("Key is a null value");
		return key.hashCode()%CAPACITY;
	}
	
}



