package ValidAnagram;

import java.util.*;
//LCA
public class Solution {
	public static void main(String []args){
		String s = "anagram";
		String t = "nagaram";
		boolean isAnagram = isAnagram(s,t);
		System.out.println(isAnagram);
	}

//	private static boolean isAnagram(String s, String t) {
//		char[] first = s.toCharArray();
//		char[] second = t.toCharArray();
//		Arrays.sort(first);
//		Arrays.sort(second);
//		s = String.copyValueOf(first);
//		t = String.valueOf(second);
//		return s.equals(t);
//	}
	
	private static boolean isAnagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){map.put(ch, map.get(ch) + 1);}
			else{map.put(ch, 1);}
		}
		for(int i = 0; i<t.length(); i++){
			char ch = t.charAt(i);
			if(!map.containsKey(ch)){return false;}
			if(map.get(ch) == 1){map.remove(ch);}
			else{map.put(ch, map.get(ch) - 1);}
		}
		return map.size() == 0;
	}
	
	
}
