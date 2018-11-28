package GroupShiftedStrings;

import java.util.*;
import java.util.Map.Entry;
// LL
public class Solution {

	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", null, "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> result = getGroupShiftedStrings(strings);
		System.out.println(result);
	}

	private static List<List<String>> getGroupShiftedStrings(String[] strings) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		if(strings == null || strings.length == 0){return result;}
		for(String s : strings){
			if(s == null){continue;}
			String key = new String();
			if(s.length() == 1){
				key = "1";
			}
			else{
				StringBuilder sb = new StringBuilder();
				int prev = s.charAt(0)%26;
				for(int i = 1; i<s.length(); i++){
					int curr = s.charAt(i)%26;
					sb.append(curr - prev);
					prev = curr;
				}
				key = sb.toString();
			}
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<>(Arrays.asList(s)));
			}else{
				map.get(key).add(s);
			}
		}
		for(Entry<String, List<String>> entry : map.entrySet()){
			Collections.sort(entry.getValue());
		}
		
		result.addAll(map.values());
		return result;
	}

}
