package ImplementTrie;

public class Trie {
	TrieNode node;
	public Trie(){
		node = new TrieNode();
	}
	public void insert(String word) {
		TrieNode temp = node;
		for(int i = 0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(temp.child[ch-'a'] == null){
				temp.child[ch-'a'] = new TrieNode();
			}
			temp = temp.child[ch-'a'];
		}
		temp.isWord = true;
	}
	public boolean search(String word) {
		TrieNode temp = node;
		for(int i = 0; i< word.length(); i++){
			char ch = word.charAt(i);
			if(temp.child[ch - 'a'] == null){return false;}
			temp = temp.child[ch - 'a'];
		}
		return temp.isWord;
	}
	public boolean startsWith(String prefix) {
		TrieNode temp = node;
		for(int i = 0; i< prefix.length() ; i++){
			char ch = prefix.charAt(i);
			if(temp.child[ch - 'a'] == null){return false;}
			temp = temp.child[ch-'a'];
		}
		return true;
	}
	
}
