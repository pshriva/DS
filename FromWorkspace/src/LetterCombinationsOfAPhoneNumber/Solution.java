package LetterCombinationsOfAPhoneNumber;
//LCA
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	static Map<Character, List<Character>> map = new HashMap<>();
	public static void main(String[] args) {
		String str = "523";
		List<String> result = getCombinations(str);
		System.out.println(result);
	}

	private static List<String> getCombinations(String str) {
		if(str == null || str.length() == 0) {return new ArrayList<String>();}
		String[] maps = {"","","abc","def","ghi","jkl", "mno","pqrs","tuv","wxyz"};
		List<String> list = new ArrayList<>();
		list.add("");
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String current = maps[ch - '0'];
			List<String> temp = new ArrayList<>();
			for(String l : list) {
				for(int j = 0; j<current.length(); j++) {
					temp.add(l + current.charAt(j));
				}
			}
			list = temp;
		}
		return list;
	}
}
