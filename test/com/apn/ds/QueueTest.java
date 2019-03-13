package com.apn.ds;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
public class QueueTest {

	Queue q;
	
	@Before
	public void setUp() throws Exception {
		q = new Queue();
	}

	
	@Test
	public void testIsEmpty() {
		assertTrue(q.isEmpty());
		
		q.add(10);
		assertFalse(q.isEmpty());
		
		q.poll();
		assertTrue(q.isEmpty());
		
		q.add(10);
		q.add(5);
		q.poll();
		assertFalse(q.isEmpty());
	}

	@Test
	public void testAdd() {
		q.add(10);
		assertEquals(10, q.peek());
		
		q.add(5);
		q.add(6);
		assertEquals(10, q.poll());
		assertEquals(5, q.poll());
		assertEquals(6, q.poll());
	}

	@Test
	public void testPeek() {
		q.add(10);
		assertEquals(10, q.peek());
		
		q.add(5);
		q.add(6);
		assertEquals(10, q.peek());
		q.poll();
		assertEquals(5, q.peek());
		q.poll();
		assertEquals(6, q.peek());
	}

	@Test
	public void testPoll() {
		q.add(10);
		assertEquals(10, q.poll());
		
		q.add(5);
		q.add(6);
		assertEquals(5, q.poll());
		assertEquals(6, q.poll());
	}

}
