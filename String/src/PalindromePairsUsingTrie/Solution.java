package PalindromePairsUsingTrie;

import java.util.*;
// https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
public class Solution {
	
	private static class Trie {
	   Trie[] next;
	   int index;
	   List<Integer> list;
	   public Trie(){
		   next = new Trie[26];
		   index = -1;
		   list = new ArrayList<>();
	   }
	}
	
	public static void main(String[] args) {
		String[] words = {"abcd","dcba","lls","s","sssll"};
		List<List<Integer>> result = palindromePairs(words);
//		System.out.println(result);
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> res = new ArrayList<>();

	    Trie root = new Trie();
			
	    for (int i = 0; i < words.length; i++) {
	        addWord(root, words[i], i);
	    }
//	    for (int i = 0; i < words.length; i++) {
//	        search(words, i, root, res);
//	    }
	    search(words, 4, root, res);
	    return res;
	}
	    
	private static void addWord(Trie root, String word, int index) {
	    for (int i = word.length() - 1; i >= 0; i--) {
	        int j = word.charAt(i) - 'a';
					
	        if (root.next[j] == null) {
	            root.next[j] = new Trie();
	        }
					
	        if (isPalindrome(word, 0, i)) {
	            root.list.add(index);
	        }
					
	        root = root.next[j];
	    }
	    	
	    root.list.add(index);
	    root.index = index;
	}
	    
	private static void search(String[] words, int i, Trie root, List<List<Integer>> res) {
	    for (int j = 0; j < words[i].length(); j++) {	
	    	if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
	    	    res.add(Arrays.asList(i, root.index));
	    	}
	    		
	    	root = root.next[words[i].charAt(j) - 'a'];
	      	if (root == null) return;
	    }
	    for (int j : root.list) {
	    	if (i == j) continue;
	    	res.add(Arrays.asList(i, j));
	    }
	}
	    
	private static boolean isPalindrome(String word, int i, int j) {
	    while (i < j) {
	    	if (word.charAt(i++) != word.charAt(j--)) return false;
	    }
	    	
	    return true;
	}

	
	

}
