package LongestSubstringWithAtmost2DistinctCharacters;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String s = "abcbbbbcccbdddadacb";
		int len = getLongestSubstringWithAtMostDiffCharacters(s);
		System.out.println(len);
	}

	private static int getLongestSubstringWithAtMostDiffCharacters(String s) {
		if(s == null || s.length() == 0){return 0;}
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int maxLength = 0;
		for(int i = 0; i< s.length(); i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){map.put(ch, map.get(ch)+1);}
			else{map.put(ch, 1);}
			if(map.size() > 2){
				maxLength = Math.max(maxLength, i-left);
				while(map.size() > 2){
					char curr = s.charAt(left);
	                if(map.get(curr) > 1){map.put(curr, map.get(curr) - 1);}
	                else{map.remove(curr);}
	                left++;
				}
			}
		}
		
		return Math.max(maxLength, s.length() - left);

//		return only maxLength if substring of exactly 2 characters is asked
//		return maxLength;
	}

}
