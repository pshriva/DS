package UniqueWordAbbreviation;

import java.util.*;

public class ValidWordAbbreviator {
	Map<String, String> map;
	public ValidWordAbbreviator(String[] dictionary){
		map = new HashMap<>();
		for(String word : dictionary){
			String abbr = getAbbreviation(word);
			if(map.containsKey(abbr) && !map.get(abbr).equals(word)){
				map.put(abbr, "");
			}else{
				map.put(abbr, word);
			}
		}
	}
	private String getAbbreviation(String word) {
		if(word == null || word.length() <= 2){return word;}
		return word.charAt(0) + "" + (word.length() - 2) + word.charAt(word.length() - 1);
	}
	public boolean isUnique(String word) {
		String abbr = (word == null || word.length() <= 2 )
					? word : (word.charAt(0) + "" + (word.length()-2) + word.charAt(word.length()-1));
		return (!map.containsKey(abbr) || map.get(abbr).equals(word));
	}
	
	
}
