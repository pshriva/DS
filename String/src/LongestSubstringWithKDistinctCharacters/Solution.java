package LongestSubstringWithKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String args[]) {
		String s = "abcbbcbcbcbbbcccbdddadacb";
		int k = 2;
		int length = getLongestSubstringLength(s, k);
		System.out.println(length);
	}

	private static int getLongestSubstringLength(String s, int k) {
		if(s == null || s.length() == 0 || s.length() < k) {return -1;}
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
		int left = 0;
		for(int i = 0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}else {map.put(s.charAt(i), 1);}
			if(map.size() > k) {
				maxLength = Math.max(maxLength, (i-left));
				while(map.size() > k) {
					if(map.get(s.charAt(left)) == 1) {map.remove(s.charAt(left));}
					else{map.put(s.charAt(left), map.get(s.charAt(left))-1);}
					left++;
				}
			}
		}
		return maxLength;
		
//		return Math.max(maxLength, s.length() - left) if at most K distinct characters is asked , not exact K
	}
}
