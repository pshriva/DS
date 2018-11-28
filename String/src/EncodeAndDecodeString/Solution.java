package EncodeAndDecodeString;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		List<String> list = new ArrayList<>();
		list.add("pr|njali");
		list.add("sh # ivastav|a");
		String encoded = encode(list);
		System.out.println(encoded);
		List<String> decoded = decode(encoded);
		System.out.println(decoded);
	}

	private static List<String> decode(String encoded) {
		List<String> result = new ArrayList<>();
		if(encoded == null || encoded.length() == 0){return result;}
		int i = 0;
		String[] temp = encoded.split(" # ");
		for(String t : temp){
			String curr = t.replace("##", "#");
			result.add(curr);
		}
		return result;
	}

	private static String encode(List<String> list) {
		if(list == null || list.size() == 0){return "";}
		StringBuilder sb = new StringBuilder();
		for(String s : list){
			String temp = s.replace("#", "##");
			sb.append(temp).append(" # ");
		}
		return sb.toString();
	}
}
