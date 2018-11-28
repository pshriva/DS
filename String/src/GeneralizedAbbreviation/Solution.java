package GeneralizedAbbreviation;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String word = "word";
		List<String> abbr = getAllAbbreviations(word);
		System.out.println(abbr);
	}

	private static List<String> getAllAbbreviations(String word) {
		List<String> result = new ArrayList<>();
		if(word == null || word.length() == 0){return result;}
		result.add(word);
		generateAbbreviations(0, word,result);
		return result;
	}

	
//	DFS + backtracking
//	private static void generateAbbreviations(int index, String word, List<String> result) {
//		if(index >= word.length()){return;}
//		for(int i = index; i< word.length(); i++){
//			for(int j = 1; j + i <= word.length(); j++){
//				String curr = word.substring(0, i) + j + word.substring(i+j);
//				result.add(curr);
//				generateAbbreviations(i+2, curr, result);
//			}
//		}
//	}
	
	
	
//	Same as above, but keeping index in inner loop, OgC
	private static void generateAbbreviations(int index, String word, List<String> result) {
		if(index >= word.length()){return;}
		for(int i = 1; i<= word.length(); i++){
			for(int j = index; j + i <= word.length(); j++){
				String curr = word.substring(0, j) + i + word.substring(i+j);
				result.add(curr);
				generateAbbreviations(j+2, curr, result);
			}
		}
	}
	
	

}
