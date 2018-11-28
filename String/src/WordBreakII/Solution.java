package WordBreakII;

import java.util.*;

public class Solution {
	static class Word {
		int len;
		String word;
		public Word(String word, int len){
			this.word = word;
			this.len = len;
		}
	}
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
//		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog", "d", "o", "g", "og");
//		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		String s = "pineapplepenapple";
//		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//		String s = "catsandog";
		boolean isFound = search(s, wordDict);
		
		List<String> result = formStrings(s, wordDict);
		System.out.println(result);
	}
	
//	DFS and accepted
	private static List<String> formStrings(String s, List<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, ArrayList<String>>());
	}
	
	private static List<String> dfs(String s, List<String> wordDict, HashMap<String, ArrayList<String>> map) {
		if(map.containsKey(s)){
			return map.get(s);	
		}
		ArrayList<String> result = new ArrayList<>();
		if(s.length() == 0){
			result.add("");
			return result;
		}
		
		for(String word : wordDict){
			if(s.startsWith(word)){
				List<String> sub = dfs(s.substring(word.length()), wordDict, map);
				for(String su : sub){
					result.add(word + (su.isEmpty() ? "" : " ") + su);
				}
			}
		}
		map.put(s, result);
		return result;
	}
//BFS, time limit exceeded, BFS considering that dictionary len is greater that the word length
//	private static List<String> formStrings(String s, List<String> wordDict) {
//		List<String> result = new ArrayList<>();
//		Set<String> set = new HashSet<>();
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		for(String word : wordDict){
//			set.add(word);
//			min = Math.min(min, word.length());
//			max = Math.max(max, word.length());
//		}
//		
//		Queue<String> queue = new LinkedList<>();
//		queue.add("");
//		
//		while(!queue.isEmpty()){
//			String curr = queue.poll();
//			if(curr.replaceAll(" ", "").length() == s.length()){
//				result.add(curr.substring(0, curr.length() - 1));
//				continue;
//			}
//			String left = s.substring(curr.replaceAll(" ", "").length());
//			for(int j = min; j <= Math.min(left.length(), max); j++){
//				String temp = left.substring(0, j);
//				if(set.contains(temp)){
//					queue.add(curr + temp + " ");
//				}
//			}
//		}
//		return result;
//	}
	
//	BFS, time limit exceeded
//	private static List<String> formStrings(String s, List<String> wordDict) {
//		List<String> result = new ArrayList<>();
//		Set<String> set = new HashSet<>();
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		for(String word : wordDict){
//			set.add(word);
//			min = Math.min(min, word.length());
//			max = Math.max(max, word.length());
//		}
//		
//		Queue<Word> queue = new LinkedList<>();
//		queue.add(new Word("", 0));
//		while(!queue.isEmpty()){
//			String curr = queue.peek().word;
//			int len = queue.peek().len;
//			queue.poll();
//			if(len == s.length()){
//				result.add(curr.substring(0, curr.length() - 1));
//				continue;
//			}
//			String left = s.substring(len);
//			for(int j = min; j <= Math.min(left.length(), max); j++){
//				String temp = left.substring(0, j);
//				if(set.contains(temp)){
//					queue.add(new Word(curr + temp + " ", len + temp.length()));
//				}
//			}
//		}
//		return result;
//	}
//	
	


//	BFS, time limit exceeded, (BFS considering that dictionary is smaller than the word)
//	private static List<String> formStrings(String s, List<String> wordDict) {
//		List<String> result = new ArrayList<>();
//		Set<String> set = new HashSet<>();
//		for(String word : wordDict){
//			set.add(word);
//		}
//		
//		Queue<String> queue = new LinkedList<>();
//		queue.add("");
//		
//		while(!queue.isEmpty()){
//			String curr = queue.poll();
//			if(curr.replaceAll(" ", "").length() == s.length()){
//				result.add(curr.substring(0, curr.length() - 1));
//				continue;
//			}
//			String left = s.substring(curr.replaceAll(" ", "").length());
//			for(String word : set){
//				if(left.startsWith(word)){
//					String sub = curr + word + " ";
//					queue.add(sub);
//				}
//			}
//		}
//		return result;
//	}
	
//	WB1, recursive, LCA
//	private static boolean search(String s, List<String> wordDict) {
//		if(wordDict.contains(s)){return true;}
//		if(set.contains(s)){return false;}
//		for(String word : wordDict){
//			if(s.startsWith(word) && search(s.substring(word.length()), wordDict)){return true;}
//		}
//		set.add(s);
//		return false;
//	}

	

	//	WB1 iterative
	private static boolean search(String s, List<String> wordDict) {
		if(s == null || s.length() == 0){return false;}
		Map<String, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(String word : wordDict){
			map.put(word, word.length());
			min = Math.min(min, word.length());
			max = Math.max(max, word.length());
		}
		boolean[] b = new boolean[s.length() + 1];
		b[0] = true;
		for(int i = min; i<= s.length(); i++){
			for(int j = min; j<= max; j++){
				if(j > i){break;}
				if(b[i-j] && map.containsKey(s.substring(i-j, i))){
					b[i] = true;
					break;
				}
			}
		}
		return b[s.length()];
	}

}
