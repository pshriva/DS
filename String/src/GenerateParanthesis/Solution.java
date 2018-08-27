package GenerateParanthesis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int n = 3;
		Set<String> result = generateParanthesis(n);
		System.out.println(result);
	}

	private static Set<String> generateParanthesis(int n) {
		if( n<=0) {return null;}
		Set<String> pile = new HashSet<>(Arrays.asList("()"));
		for(int i = 1; i<n; i++) {
			Set<String> current = new HashSet<>();
			for(String s : pile) {
				for(int j = 0; j<=s.length(); j++) {
					current.add((s.substring(0,j) + "()" + s.substring(j, s.length())));
				}
			}
			pile = current;
		}
		return pile;
	}

}
