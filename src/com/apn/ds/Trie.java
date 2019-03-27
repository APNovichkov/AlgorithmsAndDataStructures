package com.apn.ds;

public class Trie {

	final static int ALPHABET_LENGTH = 'z'-'a'+1;
	
	private class Node{
		public int numWordsBelow;
		public boolean isWord;
		
		Node[] nodes;
		
		public Node() {
			numWordsBelow = 0;
			isWord = false;
		}
	}
	
	Node root = new Node();
	
	
	public void add(String word) {
		Node cNode = root;
	
		for(char ch: word.toCharArray()) {
			if(cNode.nodes == null) {
				cNode.nodes = new Node[ALPHABET_LENGTH];
			}
			
			cNode.nodes[ch-'a'] = new Node();
			cNode.numWordsBelow++;
			cNode = cNode.nodes[ch-'a'];
		}
		
		cNode.isWord=true;
	}
	
	public boolean containsWord(String word) {
		boolean contWord = true;
		Node cNode = root;
		
		for(char ch: word.toCharArray()) {
			if(cNode.nodes == null) return false;
			
			if(cNode.nodes[ch-'a'] == null){
				contWord = false;
				break;
			}
			cNode = cNode.nodes[ch-'a'];
		}
		
		if(!cNode.isWord) contWord = false;
		
		return contWord;
	}
	
	public boolean containsPrefix(String prefix) {
		
		return true;
	}
	
	public int numWordsWithPrefix(String prefix) {
		
		
		
		return 0;
	}
	
}
