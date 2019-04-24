package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	LinkedList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkedList<Integer>();
	}

	@Test
	public void testIsEmpty() {
		
		assertTrue(list.isEmpty());
		
	}

	@Test
	public void testPeekFirst() {
		list.addFirst(5);
		list.addFirst(6);
		
		list.addLast(4);
		
		assertEquals(6, (int) list.peekFirst());
	}

	@Test
	public void testPeekLast() {
		list.addFirst(4);
		list.addFirst(10);
		assertEquals(4, (int) list.peekLast());
		
		list.addLast(56);
		assertEquals(56, (int) list.peekLast());
	}

	@Test
	public void testRemoveFirst() {
		list.addFirst(4);
		list.removeFirst();
		assertTrue(list.isEmpty());
		assertTrue(!list.contains(4));
		
		list.addFirst(50);
		list.addFirst(60);
		
		list.removeFirst();
		
		assertTrue(!list.isEmpty());
		assertTrue(!list.contains(60));
	}

	@Test
	public void testRemoveLast() {
		list.addFirst(5);
		list.removeLast();
		
		assertTrue(list.isEmpty());
		assertTrue(!list.contains(5));
		
		list.addFirst(50);
		list.addFirst(60);
		
		list.removeLast();
		
		assertTrue(!list.isEmpty());
		assertTrue(!list.contains(50));
		assertEquals(1, list.size());
	}

	@Test
	public void testAddFirst() {
		list.addFirst(5);
		list.addFirst(6);
		
		list.addLast(3);
		
		assertEquals(6, (int) list.peekFirst());
	}

	@Test
	public void testAddLast() {
		list.addLast(5);
		list.addLast(6);
		
		list.addFirst(3);
		
		assertEquals(6, (int) list.peekLast());
	}

	@Test
	public void testSize() {
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		
		assertEquals(3, list.size());
	}

	
	//TO-DO
	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testReverseIterator() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public void testInsert() {
		list.addFirst(4);
		list.addFirst(5);
		assertEquals(2, list.size());
		
		list.insert(0, 3);
		assertEquals(3, (int) list.peekFirst());
		assertEquals(3, list.size());
		assertTrue(list.contains(3));
		
		
		list.insert(3, 6);
		assertEquals(6, (int) list.peekLast());
		assertTrue(list.contains(6));
		
		list.insert(2, 20);
		assertEquals(5, list.size());
		assertTrue(list.contains(20));
	}

	
	//@Test
	public void testRemoveInt() {
		list.addFirst(4);
		list.addLast(6);
		list.addFirst(40);
		
		
		
		list.remove(2);
		
		assertTrue(!list.contains(6));
		assertEquals(2, list.size());
		
		list.addFirst(50);
		list.addFirst(60);
		
		list.remove(2);
		assertEquals(3, list.size());
		assertTrue(!list.contains(40));
	}

	
	//TO do
	@Test
	public void testRemoveV() {
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(40);
		
		Integer a = new Integer(3);
		
		list.remove(a);
		
		//assertTrue(!list.contains(40));
		assertEquals(2, list.size());
	}

	
	//To do
	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		list.addFirst(4);
		list.addFirst(5);
		
		assertTrue(list.contains(4));
		assertTrue(list.contains(5));
		assertTrue(!list.contains(6));
		
		
		
	}

}
