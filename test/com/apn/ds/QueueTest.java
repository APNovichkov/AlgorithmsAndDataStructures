package com.apn.ds;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
public class QueueTest {

	Queue<Integer> q;
	
	@Before
	public void setUp() throws Exception {
		q = new Queue<Integer>();
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

	
	
	//FIX
	@Test
	public void testAdd() {
		q.add(10);
		
		assertEquals(10, (int) q.peek());
		
		q.add(5);
		q.add(6);
		assertEquals(10,(int) q.poll());
		assertEquals(5, (int)q.poll());
		assertEquals(6,(int) q.poll());
	}

	@Test
	public void testPeek() {
		q.add(10);
		assertEquals(10,(int) q.peek());
		
		q.add(5);
		q.add(6);
		assertEquals(10, (int)q.peek());
		q.poll();
		assertEquals(5,(int) q.peek());
		q.poll();
		assertEquals(6, (int)q.peek());
	}

	@Test
	public void testPoll() {
		q.add(10);
		assertEquals(10,(int) q.poll());
		
		q.add(5);
		q.add(6);
		assertEquals(5,(int) q.poll());
		assertEquals(6,(int) q.poll());
	}

}
