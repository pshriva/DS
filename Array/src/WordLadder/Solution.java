package WordLadder;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
		int ladderLength = getLadderLength(beginWord, endWord, wordList);
		System.out.println(ladderLength);
	}
//	TLE
	private static int getLadderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		wordList.add(endWord);
		int distance = 1;
		while(!path.contains(endWord)){
			List<String> next = new ArrayList<>();
			for(String str : path){
				char[] curr = str.toCharArray();
				for(int i = 0; i<curr.length; i++){
					for(char j = 'a'; j<= 'z'; j++){
						char temp = curr[i];
						curr[i] = j;
						String word = String.copyValueOf(curr);
						if(wordList.contains(word)){
							wordList.remove(word);
							next.add(word);
						}
						curr[i] = temp;
					}
				}
			}
			path = next;
			if(next.size() == 0){return 0;}
			distance++;
		}
		return distance;
	}
// Correct solution but time limit exceeds, as they assume very large dictionaries
//	private static int getLadderLength(String beginWord, String endWord, List<String> wordList) {
//		List<String> path = new ArrayList<>();
//		List<String> visited = new ArrayList<>();
//	    wordList.add(endWord);
//		path.add(beginWord);
//		int distance = 1;
//		while(!path.contains(endWord)){
//			List<String> nextPath = new ArrayList<>();
//			for(String s : path){
//				for(String word : wordList){
//					if(isDistanceOne(s, word) && !visited.contains(word)){
//						nextPath.add(word);
//						visited.add(word);
//					}
//				}
//			}
//			path = nextPath;
//			distance++;
//		}
//		return distance;
//	}
	
//	Using Iterator
//	private static int getLadderLength(String beginWord, String endWord, List<String> wordList) {
//		List<String> path = new ArrayList<>();
//		List<String> visited = new ArrayList<>();
//      wordList.add(endWord);
//		path.add(beginWord);
//		int distance = 1;
//		while(!path.contains(endWord)){
//			List<String> nextPath = new ArrayList<>();
//			for(String s : path){
//				Iterator<String> it = wordList.iterator();
//				while(it.hasNext()){
//					String str = it.next();
//					if(isDistanceOne(s, str)){
//						nextPath.add(str);
//						it.remove();
//					}
//				}
//			}
//			path = nextPath;
//			distance++;
//		}
//		return distance;
//	}



	private static boolean isDistanceOne(String s, String word) {
		int d = 0;
		for(int i = 0; i< s.length(); i++){
			if(s.charAt(i) != word.charAt(i)){d++;}
			if(d > 1){return false;}
		}
		return true;
	}

}
