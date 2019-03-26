package com.apn.alg;

import com.apn.ds.Node;
import com.apn.ds.Queue;

public class BtTraversalIterative {

	
	public static <T> void levelOrder(Node<T> root, Visitor<T> visitor) {
		Queue<Node<T>> q = new Queue<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node<T> node = q.poll();
			visitor.visit(node);
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}
	
}
