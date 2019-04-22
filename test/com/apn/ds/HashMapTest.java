package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashMapTest {

	HashMap<String,Integer> map;
	
	@Before
	public void setUp() throws Exception {
		map = new HashMap<>();
	}

	@Test
	public void testSize() {
		map.put("A", 5);
		assertEquals(1, map.size());
		map.put("B", 3);
		assertEquals(2, map.size());
		map.remove("A");
		map.remove("B");
		assertEquals(0, map.size());
	}

	@Test
	public void testPut() {
		map.put("A", 5);
		map.put("B", 3);
		
		assertTrue(map.containsKey("A"));
		assertTrue(map.containsKey("B"));
		assertTrue(!map.containsKey("C"));
		
		map.put("A", 3);
		assertTrue(map.containsKey("A"));
		assertEquals((int) 3, (int) map.get("A"));
	}

	@Test
	public void testGet() {
		map.put("A", 5);
		map.put("B", 3);
		assertEquals(5, (int) map.get("A"));
		assertEquals(3, (int) map.get("B"));
		assertEquals(null, map.get("C"));
	}

	@Test
	public void testContainsKey() {
		map.put("A", 5);
		map.put("B", 3);
		
		assertTrue(map.containsKey("A"));
		assertTrue(map.containsKey("B"));
		assertTrue(!map.containsKey("C"));
	}

	@Test
	public void testRemove() {
		map.put("A", 5);
		map.put("B", 3);
		assertTrue(map.containsKey("A"));
		
		map.remove("A");
		assertTrue(!map.containsKey("A"));
	}

	@Test
	public void testKeys() {
		map.put("A", 5);
		map.put("B", 3);
		
		//to do. I think i need to fix iterator
	}

	@Test
	public void testValues() {
		fail("Not yet implemented");
	}

}
