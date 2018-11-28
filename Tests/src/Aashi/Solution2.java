package Aashi;

import java.util.TreeMap;

public class Solution2 {
	
	public static String findvoter(String[] str){
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		if(str.length == 0)
			return null;
		for(int i = 0 ; i < str.length;i++){
			if(!map.containsKey(str[i])){
				map.put(str[i], 1);
			}
			else
				map.put(str[i], map.get(str[i]) + 1);
		}
		int max = 0;
		String res = "";
		for(String s: map.keySet()){
			if(map.get(s) >= max){
				max = map.get(s);
				res = s;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] str = {"Alex", "Michael", "Harry","Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
		System.out.println(findvoter(str));
	}

}
