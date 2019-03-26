package com.apn.alg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.apn.ds.Node;
import com.apn.ds.Utils;

public class BtTraversalRecursiveTest {

	Node<String> root;
	Visitor<String> visitor;
	
	
	@Before
	public void setUp() throws Exception {
		root = Utils.buildBinaryTree();
		visitor = Utils.buildPrintVisitor();
	}

	@Test
	public void testPreOrder() {
		System.out.println("Pre-Order:");
		BtTraversalRecursive.preOrder(root, visitor);
		assertEquals("ABDEGCF", visitor.toString());
		System.out.println();
	}

	@Test
	public void testPostOrder() {
		System.out.println("Post-Order:");
		BtTraversalRecursive.postOrder(root, visitor);
		assertEquals("DGEBFCA", visitor.toString());
		System.out.println();
	}

	@Test
	public void testInOrder() {
		System.out.println("In-Order:");
		BtTraversalRecursive.inOrder(root, visitor);
		assertEquals("DBGEACF", visitor.toString());
		System.out.println();
	}

}
