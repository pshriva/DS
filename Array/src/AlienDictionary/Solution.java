package AlienDictionary;

import java.util.*;

// Reference: https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
public class Solution {

	public static void main(String[] args) {
		String[] words = {"wrt","wrf","er","ett","rftt"};
//		System.out.println((char)(1 + 'a'));
		String order = getAlienOrder(words);
		System.out.println(order);
	}

	private static String getAlienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		int[] inDegree = new int[26];
		createGraph(words, graph, inDegree);
		String order = getDictionaryOrder(graph, inDegree);
		return order.length() == graph.size() ? order : null;
	}

	private static String getDictionaryOrder(Map<Character, Set<Character>> graph, int[] inDegree) {
		Queue<Character> queue = new LinkedList<>();
		for(char key : graph.keySet()){
			if(inDegree[key - 'a'] == 0){
				queue.add(key);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			char ch = queue.poll();
			sb.append(ch);
			for(char c : graph.get(ch)){
				if(--inDegree[c-'a'] == 0){
					queue.add(c);
				}
			}
		}
		return sb.toString();
	}

	private static void createGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
		for(String word : words){
			for(char c : word.toCharArray()){
				graph.put(c, new HashSet<Character>());
			}
		}
		for(int i = 0; i<words.length - 1; i++){
			String first = words[i];
			String second = words[i+1];
			int j = 0;
			while(j < first.length() && j < second.length()){
				char parent = first.charAt(j);
				char child = second.charAt(j);
				if(parent != child){
					graph.get(parent).add(child);
					inDegree[child-'a']++;
					break;
				}
				j++;
			}
		}
	}

	

}
