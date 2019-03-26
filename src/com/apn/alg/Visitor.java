package com.apn.alg;

import com.apn.ds.Node;

public interface Visitor<T> {

	public void visit(Node<T> node);
	
}
