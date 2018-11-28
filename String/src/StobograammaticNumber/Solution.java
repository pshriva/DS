package StobograammaticNumber;

import java.util.*;
//LL : Find if the given number is stobogrammatic
public class Solution {

	public static void main(String[] args) {
		String s ="818";
		boolean isStobogrammatic = isStobogrammatic(s);
		System.out.println(isStobogrammatic);
	}

	private static boolean isStobogrammatic(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('1', '1');
		map.put('6', '6');
		map.put('8', '8');
		map.put('9', '6');
		map.put('0', '0');
		int left = 0;
		int right = s.length()-1;
		while(left <= right){
			if(!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) != s.charAt(left)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
