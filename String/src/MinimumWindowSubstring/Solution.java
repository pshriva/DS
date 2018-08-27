package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String [] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String result = getMinimumWindowString(s, t);
		System.out.println(result);
	}

	private static String getMinimumWindowString(String s, String t) {
		Map<Character, Integer> tmap = new HashMap<>();
		Map<Character, Integer> smap = new HashMap<>();
		String result = "";
		int count = 0;
		int left = 0;
		int minLength = Integer.MAX_VALUE;
		for(int i = 0; i< t.length(); i++) {
			if(tmap.containsKey(t.charAt(i))) {tmap.put(t.charAt(i), tmap.get(t.charAt(i)) + 1);}
			else {tmap.put(t.charAt(i), 1);}
		}
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(tmap.containsKey(ch)) {
				if(smap.containsKey(ch)) {
					if(smap.get(ch) < tmap.get(ch)) {count++;}
					smap.put(ch, smap.get(ch)+1);
				}else {
					count++;
					smap.put(ch, 1);
				}
			}
			if(count == t.length()) {
				char c = s.charAt(left);
				while(!tmap.containsKey(c) || (tmap.get(c) < smap.get(c))) {
					if(smap.containsKey(c)) {
						smap.put(c, smap.get(c)-1);
					}
					left++;
					c = s.charAt(left);
				}
				if(i-left + 1 <= minLength) {
					result = s.substring(left, i+1);
					minLength = i - left + 1;
				}
			}
		}
		return result;
	}
}
