package RemoveDuplicateLetters;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
//		String s = "caccabad";
		String s = "cbacdcbc";
		String result = removeDuplicates(s);
		System.out.println(result);
	}

	
	private static String removeDuplicates(String s) {
		if(s == null || s.length() <= 1){return s;}
		Map<Character, Integer> count = new HashMap<>();
		Map<Character, Boolean> visited = new HashMap<>();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(count.containsKey(ch)){count.put(ch, count.get(ch) + 1);}
			else{count.put(ch, 1);}
			visited.put(ch, false);
		}
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			count.put(ch, count.get(ch)-1);
			if(visited.get(ch)){
				continue;
			}
			while(!stack.isEmpty() && stack.peek() > ch && count.get(stack.peek()) > 0){
				visited.put(stack.pop(), false);
			}
			stack.push(ch);
			visited.put(ch, true);
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}
	
//	Above one with explanation
//	private static String removeDuplicates(String s) {
//		if(s == null || s.length() <= 1){return s;}
//		Map<Character, Integer> count = new HashMap<>();
//		Map<Character, Boolean> visited = new HashMap<>();
//		Stack<Character> stack = new Stack<>();
//		for(int i = 0; i<s.length(); i++){
//			char ch = s.charAt(i);
//			if(count.containsKey(ch)){count.put(ch, count.get(ch) + 1);}
//			else{count.put(ch, 1);}
//			visited.put(ch, false);
//		}
//		for(Character key : count.keySet()){
//			System.out.println(key + " " + count.get(key));
//		}
//		for(int i = 0; i<s.length(); i++){
//			char ch = s.charAt(i);
//			System.out.println("*** char is " + i + " : " + ch + " ***");
//			System.out.println("	count has " + count.get(ch) + " " + ch + "'s");
//			count.put(ch, count.get(ch)-1);
//			System.out.println("	Count has " + count.get(ch) + " " + ch + "'s left");
//			if(visited.get(ch)){
//				System.out.println("	It was visited earlier so continuing");
//				continue;
//			}
//			while(!stack.isEmpty() && stack.peek() > ch && count.get(stack.peek()) > 0){
//				System.out.println("	Top in the stack was same and greater as  " + stack.peek() + " so removing it and making its visited false");
//				visited.put(stack.pop(), false);
//			}
//			System.out.println("	Pushing " + ch + " in the stack");
//			stack.push(ch);
//			System.out.println("	Making its visited true");
//			visited.put(ch, true);
//		}
//		StringBuilder sb = new StringBuilder();
//		while(!stack.isEmpty()){
//			sb.insert(0, stack.pop());
//		}
//		return sb.toString();
//	}

//	http://buttercola.blogspot.com/2016/01/leetcode-remove-duplicate-letters.html
//	O(n2)
//	private static String removeDuplicates(String s) {
//		if(s == null || s.length() <= 1){return s;}
//		Map<Character, Integer> map = new HashMap<>();
//		for(int i = 0; i< s.length(); i++){
//			map.put(s.charAt(i), i);
//		}
//		for(char key : map.keySet()){
//			System.out.println(key + " " + map.get(key));
//		}
//		StringBuilder sb  = new StringBuilder();
//		int start = 0;
//		int end = findSmallestIndex(map);
//		while(!map.isEmpty()){
//			char curr = 'z' + 1;
//			int index = 0;
//			for(int i = start ; i<=end ;i++){
//				char c = s.charAt(i);
//				if(c < curr && map.containsKey(c)){
//					curr = c;
//					index = i;
//				}
//			}
//			
//			sb.append(curr);
//			map.remove(curr);
//			start = index+1;
//			end = findSmallestIndex(map);
//		}
//		return sb.toString();
//	}
//
//	private static int findSmallestIndex(Map<Character, Integer> map) {
//		int smallestIndex = Integer.MAX_VALUE;
//		for(int i : map.values()){
//			smallestIndex = Math.min(smallestIndex, i);
//		}
//		return smallestIndex;
//	}

}
