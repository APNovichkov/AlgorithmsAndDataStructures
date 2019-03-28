package com.apn.ds;

public class Trie {

	final static int ALPHABET_LENGTH = 'z'-'a'+1;
	
	private class Node{
		public int numWordsAtLetter;
		public boolean isWord;
		
		Node[] nodes;
		
		public Node() {
			numWordsAtLetter = 0;
			isWord = false;
		}
	}
	
	Node root = new Node();
	
	//TO FIX
	public void add(String word) {
		Node cNode = root;
	
		for(char ch: word.toCharArray()) {
			if(cNode.nodes == null) {
				cNode.nodes = new Node[ALPHABET_LENGTH];
			}
			
			if(cNode.nodes[letterIndex(ch)] == null) {
				cNode.nodes[letterIndex(ch)] = new Node();
			} 
			
		
			cNode = cNode.nodes[letterIndex(ch)];
			cNode.numWordsAtLetter++;
		}
		
		cNode.isWord=true;
	}
	
	public boolean containsWord(String word) {
		boolean contWord = true;
		Node cNode = root;
		
		for(char ch: word.toCharArray()) {
			if(cNode.nodes == null) return false;
			
			if(cNode.nodes[letterIndex(ch)] == null){
				contWord = false;
				break;
			}
			cNode = cNode.nodes[letterIndex(ch)];
		}
		
		if(!cNode.isWord) contWord = false;
		
		return contWord;
	}
	
	public boolean containsPrefix(String prefix) {
		boolean contPrefix = true;
		Node cNode = root;
		
		for(char ch: prefix.toCharArray()) {
			if(cNode.nodes == null) return false;
			
			if(cNode.nodes[letterIndex(ch)] == null){
				contPrefix = false;
				break;
			}
			cNode = cNode.nodes[letterIndex(ch)];
		}
		
		return contPrefix;
		
	}
	
	public int numWordsWithPrefix(String prefix) {
		Node cNode = root;
		
		for(char ch: prefix.toCharArray()) {
			if(cNode.nodes == null || cNode.nodes[letterIndex(ch)] == null) return 0;
			cNode = cNode.nodes[letterIndex(ch)];
		}
		
		return cNode.numWordsAtLetter;
	}
	
	private int letterIndex(char ch) {
		return ch-'a';
	}
	
}
