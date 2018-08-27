package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		String roman = "III";
		int number = getInteger(roman);
		System.out.println(number);
	}

	private static int getInteger(String roman) {
		if(roman == null || roman.length() == 0) {return -1;}
		int number = 0;
		Map<Character,Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		for(int i = 0; i < roman.length(); i++) {
			char ch = roman.charAt(i);
			if(i != 0 && map.get(ch) > map.get(roman.charAt(i-1))) {
				number = number + map.get(ch) - 2*(map.get(roman.charAt(i-1)));
			}else {
				number = number + map.get(ch);
			}
		}
		return number;
	}

}
