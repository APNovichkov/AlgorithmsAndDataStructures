package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

	ArrayList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>(2);
	}

	@Test
	public void testSize() {
		list.add(5);
		list.add(6);
		
		assertEquals(2, list.size());
	}

	@Test
	public void testAdd() {
		list.add(5);
		list.add(10);
		list.add(20);
		
		assertEquals(3, list.size());
	}

	@Test
	public void testGet() {
		list.add(5);
		list.add(6);
		list.add(7);
		
		assertEquals(6, (int) list.get(1));
		assertEquals(7, (int) list.get(2));
	}

}
