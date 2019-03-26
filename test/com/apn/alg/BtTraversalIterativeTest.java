package com.apn.alg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.apn.ds.Node;
import com.apn.ds.Utils;

public class BtTraversalIterativeTest {

	Node<String> root;
	Visitor<String> visitor;
	
	@Before
	public void setUp() throws Exception {
		root = Utils.buildBinaryTree();
		visitor = Utils.buildPrintVisitor();
	}

	@Test
	public void testLevelOrder() {
		System.out.println("Level Oder:");
		BtTraversalIterative.levelOrder(root, visitor);
		assertEquals("ABCDEFG", visitor.toString());
		System.out.println();
	}

}
