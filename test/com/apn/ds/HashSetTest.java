package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashSetTest {

	HashSet<Integer> set;
	
	@Before
	public void setUp() throws Exception {
		set = new HashSet<Integer>();
	}

	@Test
	public void testAdd() {
		set.add(5);
		set.add(20);
		
		assertTrue(set.contains(5));
		assertTrue(set.contains(20));
		assertTrue(!set.contains(2));
	}

	@Test
	public void testRemove() {
		set.add(5);
		set.add(5);
		set.add(11);
		assertTrue(set.contains(5));
		
		set.remove(11);
		assertTrue(!set.contains(11));
		assertTrue(set.contains(5));
		
	}

	@Test
	public void testContains() {
		set.add(5);
		set.add(6);
		set.add(11);
		
		assertTrue(set.contains(5));
		assertTrue(set.contains(6));
		assertTrue(set.contains(11));
		assertTrue(!set.contains(7));
	}

	@Test
	public void testSize() {
		set.add(5);
		set.add(6);
		set.add(11);
		
		assertEquals(3, set.size());
		set.add(5);
		assertEquals(3, set.size());
		
		set.remove(5);
		assertEquals(2, set.size());
	}

}
