package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	Stack s;

	@Before
	public void setUp() throws Exception {
		s = new Stack();
	}


	@Test
	public void testIsEmpty() {		
		assertTrue(s.isEmpty());
		
		s.push(5);
		assertFalse(s.isEmpty());

		s.pop();
		assertTrue(s.isEmpty());
		
		s.push(10);
		s.push(10);
		s.pop();
		s.pop();
		assertTrue(s.isEmpty());		
	}

	@Test
	public void testPeek() {
		s.push(5);		
		assertEquals(5, s.peek());
		
		s.push(7);
		s.push(10);
		s.pop();		
		assertEquals(7, s.peek());
		
	}
	
	
	@Test
	public void testPush() {
		s.push(5);		
		assertEquals(5, s.peek());
		
		s.push(7);
		s.push(10);
		s.pop();		
		assertEquals(7, s.peek());
	}

	@Test
	public void testPop() {
		s.push(5);
		assertEquals(5, s.pop());
		
		s.push(5);
		s.push(7);
		s.push(10);
		assertEquals(10, s.pop());
		assertEquals(7, s.pop());
		assertEquals(5, s.pop());
	}

}
