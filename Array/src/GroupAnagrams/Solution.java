package GroupAnagrams;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> anagrams = groupAnagrams(strs);
		System.out.println(anagrams);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0){return new ArrayList<List<String>>();}
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			if(!map.containsKey(String.valueOf(arr))){map.put(String.valueOf(arr), new ArrayList<>());}
			map.get(String.valueOf(arr)).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}

}
