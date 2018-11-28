package PalindromePairsUsingTrie;

import java.util.*;

public class Trie {
	Trie[] child;
	int index;
	List<Integer> list;
	
	public Trie(){
		child = new Trie[26];
		index = -1;
		list = new ArrayList<>();
	}
}
