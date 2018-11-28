package PalindromePairs;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
//		String[] words = {"abcd","dcba","lls","s","sssll"};
		String[] words = {"bat","tab","cat"};
		List<List<Integer>> result = getPalindromePairs(words);
		System.out.println(result);
	}

	
//	Better than bruteforce, probably - O(N*K^3) or  O(N*K^2)
//	https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution
	private static List<List<Integer>> getPalindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		if(words == null || words.length <= 1){return result;}
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i++){
			map.put(words[i], i);
		}
		
//		Find all the pairs for "" string
		if(map.containsKey("")){
			int blankIndex = map.get("");
			for(int i = 0; i< words.length; i++){
				if(i == blankIndex){continue;}
				if(isPalindrome(words[i])){
					result.add(new ArrayList<>(Arrays.asList(blankIndex, i)));
					result.add(new ArrayList<>(Arrays.asList(i, blankIndex)));
				}
			}
		}
		
//		Find all the words and existing reverse pairs
		for(int i  = 0 ; i < words.length; i++){
			String reverseString = reverse(words[i]);
			if(map.containsKey(reverseString)){
				if(map.get(reverseString) == i){continue;}
				result.add(new ArrayList<>(Arrays.asList(i, map.get(reverseString))));
			}
		}
		
		
//		Strings that are partially palindrome and have reverse of the partial left string in the array
		for(int i = 0; i < words.length; i++){
			String curr = words[i];
			for(int j = 1; j < curr.length(); j++){
				if(isPalindrome(curr.substring(0, j))){
					String remaining = reverse(curr.substring(j));
					if(map.containsKey(remaining)){
						if(map.get(remaining) == i){continue;}
						result.add(new ArrayList<>(Arrays.asList(map.get(remaining), i)));
					}
				}
				if(isPalindrome(curr.substring(j))){
					String remaining = reverse(curr.substring(0, j));
					if(map.containsKey(remaining)){
						if(map.get(remaining) == i){continue;}
						result.add(new ArrayList<>(Arrays.asList(i, map.get(remaining))));
					}
				}
			}
		}
		return result;
	}


	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}


	private static boolean isPalindrome(String string) {
		if(string == null){return false;}
		if(string.length() == 0){return true;}
		int left = 0;
		int right = string.length() - 1;
		while(left <= right){
			if(string.charAt(left) != string.charAt(right)){return false;}
			left++;
			right--;
		}
		return true;
	}
	
//	BruteForce
//	private static List<List<Integer>> getPalindromePairs(String[] words) {
//		List<List<Integer>> result = new ArrayList<>();
//		if(words == null || words.length <= 1){return result;}
//		for(int i = 0; i<words.length; i++){
//			for(int j = 0 ; j < words.length; j++){
//				if(i == j){continue;}
//				if(isPalindrome(words[i]+words[j])){
//					result.add(new ArrayList<>(Arrays.asList(i, j)));
//				}
//			}
//		}
//		return result;
//	}
//
//	private static boolean isPalindrome(String word) {
//		int left = 0;
//		int right = word.length()-1;
//		while(left <= right){
//			if(word.charAt(left) != word.charAt(right)){return false;}
//			left++;
//			right--;
//		}
//		return true;
//	}

}
