package com.apn.ds;

/**
 * 
 * @author apnovichkov
 *
 *Start time: 9:30
 *End time: 10:00
 *
 */

public class ArrayList <V> {
	
	private final static int DEFAULT_CAPACITY = 100;
	private final static int EXPAND_FACTOR = 2; 	
	
	private V[] values;
	private int capacity;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		this.capacity = capacity;
		this.values = (V[])new Object[capacity];
		this.size = 0;
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public void add(V value) {
		ensureCapacity();
		values[size] = value;
		size++;
	}
	
	public V get(int index) {
		if(index >= size) throw new IndexOutOfBoundsException("Index is out of range: " + index);  
		return values[index];
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			V[] temp = (V[])new Object[capacity];
			System.arraycopy(values, 0, temp, 0, size);		
			values = temp;			
		}
	}
}
