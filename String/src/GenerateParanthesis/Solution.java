package GenerateParanthesis;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int n = 3;
//		Set<String> result = generateParanthesis(n);
		List<String> result = generateParanthesis(n);
		System.out.println(result);
	}
//	Better, always generate valid and UINQUE parenthesis only, so no need for the set to filter out the unique ones 
	private static List<String> generateParanthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesis(result, n, "", 0, 0);
		return result;
	}
	private static void generateParenthesis(List<String> result, int max, String string, int openingP, int closingP) {
		if(string.length() == 2*max){
			result.add(string);
			return;
		}
		if(openingP < max){
			generateParenthesis(result, max, string + "(", openingP+1, closingP);
		}
		if(closingP < openingP){
			generateParenthesis(result, max, string + ")", openingP, closingP+1);
		}
	}
	


//	private static Set<String> generateParanthesis(int n) {
//		if( n<=0) {return null;}
//		Set<String> pile = new HashSet<>(Arrays.asList("()"));
//		for(int i = 1; i<n; i++) {
//			Set<String> current = new HashSet<>();
//			for(String s : pile) {
//				for(int j = 0; j<=s.length(); j++) {
//					current.add((s.substring(0,j) + "()" + s.substring(j, s.length())));
//				}
//			}
//			pile = current;
//		}
//		return pile;
//	}

}
