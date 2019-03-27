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
		
		if(t.containsWord("helloo")) {
			System.out.println("Contains word");
		}else {
			System.out.println("Does not contain word");
		}
	}

	@Test
	public void testContainsPrefix() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumWordsWithPrefix() {
		fail("Not yet implemented");
	}

}
