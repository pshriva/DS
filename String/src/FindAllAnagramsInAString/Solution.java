package FindAllAnagramsInAString;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		List<Integer> indexes = findAnagraamIndexes(s, p);
		System.out.println(indexes);
	}

	private static List<Integer> findAnagraamIndexes(String s, String p) {
		List<Integer> indexes = new ArrayList<>();
		Map<Character, Integer> target = new HashMap<>();
		for(int i = 0; i<p.length(); i++){
			char ch = p.charAt(i);
			if(target.containsKey(ch)){target.put(ch, target.get(ch)+1);}
			else{target.put(ch, 1);}
		}
		int left = 0; 
		int count = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(target.containsKey(ch)){
				if(map.containsKey(ch)){map.put(ch, map.get(ch)+ 1);}
				else{map.put(ch, 1);}
				count++;
				if(count == p.length()){
					if(map.equals(target)){indexes.add(left);}
					if(map.get(s.charAt(left)) == 1){map.remove(s.charAt(left));}
					else{map.put(s.charAt(left), map.get(s.charAt(left)) - 1);}
					count--;
					left++;
				}
			}
			else{
				map = new HashMap();
				count = 0;
				left = i+1;
			}
		}
		return indexes;
	}

}
