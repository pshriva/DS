package FlipGame;

import java.util.*;
//LL
public class Solution {

	public static void main(String[] args) {
		String s = "++++";
		List<String> result = getValidStates(s);
		System.out.println(result);
	}

	private static List<String> getValidStates(String s) {
		List<String> result = new ArrayList<>();
		for(int i = 0; i< s.length() -1 ; i++){
			if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '+'){
				String state = s.substring(0, i) + "--" + s.substring(i+2);
				result.add(state);
			}
		}
		return result;
	}

}
