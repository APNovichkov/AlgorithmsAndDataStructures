package com.apn.ds;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>>{

	public static class Node<T>{
		Node<T> right;
		Node<T> left;
		
		T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	
	private  Node<T> root;
	
	//probably recursively
	public static <T> boolean isBinarySearchTree(Node<T> root) {
		
		boolean isBST;
		
		
		
		return false;
	}
	
	public void add(T value) {
		Node<T> newNode = new Node<>(value);
		Node<T> node = root;
		
		if(root == null) {
			root = newNode;
			return;
		}
		
		while(true) {
			if(value.compareTo(node.value) == -1) {
				if(node.left == null) {
					node.left = newNode;
					break;
				}else {
					node = node.left;
				}
			}else if(value.compareTo(node.value) == 1) {
				if(node.right == null) {
					node.right = newNode;
					break;
				}else {
					node = node.right;
				}
			}else {
				System.out.println("I dont know where to add because value is already in the tree");
			}
		}
	}
	
	public Node<T> search(T value) {
		Node<T> node = root;
		
		while(true) {
			if(node.value.compareTo(value) == 0) {
				//values are equal
				return node;
			}else if(node.value.compareTo(value) == -1) {
				//node value is less than value
				if(node.left == null) break;
				node = node.left;
			}else {
				//node value is more than value
				if(node.right == null) break;
				node = node.right;
			}
		}
		
		
		return null;
	}
	
//	static class Person implements Comparable<Person>{
//		int age;
//		int height;
//		Person(int age, int height){
//			this.age = age;
//			this.height = height;
//		}
//		
//		@Override
//		public int compareTo(Person p) {
//			return age > p.age ? 1 : (age < p.age ? -1: 0);
//		}
//	} 
//	
//	public static void main(String[] args) {
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(new Person(30, 180));
//		persons.add(new Person(20, 190));
//		persons.add(new Person(10, 200));
//		persons.add(new Person(40, 150));
//		
////		List<String> vals = new ArrayList<String>();
////		vals.add("aaa");
//		
////		Collections.sort(persons, new Comparator<Person>() {
////
////			@Override
////			public int compare(Person p1, Person p2) {
////				return p1.age > p2.age ? -1 :(p1.age < p2.age ? 1 : 0 );
////			}
////		});
//		
//		Collections.sort(persons);
//		
//		for(Person p: persons) {
//			System.out.println(p.age);
//		}
//	}
//	
}
