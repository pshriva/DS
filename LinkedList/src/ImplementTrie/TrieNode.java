package ImplementTrie;

public class TrieNode {
	boolean isWord;
	TrieNode[] child;
	public TrieNode(){
		isWord = false;
		child = new TrieNode[26];
	}
}
