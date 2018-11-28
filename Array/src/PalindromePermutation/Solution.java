package PalindromePermutation;

import java.util.*;

//LL https://leetcode.com/articles/palindrome-permutation/
// Find if there exists a permutation of the given string that can form a palindrome
public class Solution {
	
	public static void main(String[] args) {
//		String s = "code";
//		String s = "aab";
		String s = "carerac";
//		String s = "carerc";
		boolean isPalindrome = findPalindrome(s);
		System.out.println(isPalindrome);
	}
	
	
//	TC -O(n), SC = O(n), 1 time traversal
	private static boolean findPalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i<s.length(); i++){
			if(!set.add(s.charAt(i))){set.remove(s.charAt(i));}
		}
		return set.size() <= 1;
	}
	
	
//	private static boolean findPalindrome(String s) {
//		BitSet b = new BitSet(256);
//		for(int i = 0 ; i <s.length(); i++){
//			b.flip(s.charAt(i));
//		}
////		O(256) for cardinality, returns number of bits set to 1
//		return b.cardinality()<= 1;
//	}

	
//	TC -O(n), SC = O(n), 1 time traversal
//	private static boolean findPalindrome(String s) {
//		Map<Character, Integer> map = new HashMap<>();
//		int count = 0;
//		for(int i = 0; i<s.length() ; i++){
//			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//			if(map.get(s.charAt(i)) % 2 == 0){count--;}
//			else{count++;}
//		}
//		return count <= 1;
//	}
	
//	TC -O(n), SC = O(n), but 2 time traversal
//	private static boolean findPalindrome(String s) {
//		Map<Character, Integer> map = new HashMap<>();
//		for(int i = 0; i<s.length() ; i++){
//			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//		}
//		int count = 0;
//		for(char key : map.keySet()){
//			count += map.get(key)%2;
//		}
//		return count <= 1;
//	}
	
	

	
	
	
//	TC - O(128*n) ~= O(n), SC = O(1)
//	private static boolean findPalindrome(String s) {
//		int count = 0;
//		for(char i = 0; i< 128 && count <= 1; i++){
//			int curr = 0;
//			for(int j = 0; j < s.length(); j++){
//				if(s.charAt(j) == i){curr++;}
//			}
//			count += curr%2;
//		}
//		return count <= 1;
//	}

}
