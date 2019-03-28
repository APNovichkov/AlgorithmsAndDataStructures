package com.apn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {

	Trie t;
	
	@Before
	public void setUp() throws Exception {
		 t = new Trie();
	
	}

	@Test
	public void testAdd() {
		t.add("hello");
	}

	@Test
	public void testContainsWord() {
		t.add("hello");
		t.add("what");
		t.add("can");
		t.add("cant");
		t.add("cannot");
		
		assertTrue(t.containsWord("hello"));
		assertTrue(t.containsWord("cant"));
		assertFalse(t.containsWord("cann"));
	}

	@Test
	public void testContainsPrefix() {
		t.add("hello");
		t.add("what");
		t.add("can");
		t.add("cant");
		t.add("cannot");
		
		assertTrue(t.containsPrefix("h"));
		assertTrue(t.containsPrefix("w"));
		assertTrue(t.containsPrefix("c"));
		assertTrue(t.containsPrefix("can"));
		assertFalse(t.containsPrefix("cannt"));
	}

	@Test
	public void testNumWordsWithPrefix() {
		t.add("hello");
		t.add("what");
		t.add("can");
		t.add("cant");
		t.add("cannot");
		
		assertEquals(0, t.numWordsWithPrefix("z"));
		assertEquals(3, t.numWordsWithPrefix("can"));
		assertEquals(1, t.numWordsWithPrefix("w"));
		
	}

}
