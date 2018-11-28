package GraphValidTree;

import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//		int n = 5;
//		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}};
		boolean isValid = isValidTree(edges, n);
		System.out.println(isValid);
	}
// For DFS without recursion, use Stack same as queue in the below BFS solution
	
//	DFS
//	private static boolean isValidTree(int[][] edges, int n) {
//		boolean[] visited = new boolean[n];
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		for(int i = 0; i<n; i++){
//			map.put(i, new ArrayList<>());
//		}
//		for(int[] edge : edges){
//			map.get(edge[0]).add(edge[1]);
//			map.get(edge[1]).add(edge[0]);
//		}
//		boolean visit = helper(0, -1, map, visited);
//		if(!visit)return false;
//		for(boolean b : visited){if(!b)return false;}
//		return true;
//	}
//
//	private static boolean helper(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
//		if(visited[curr]){return false;}
//		visited[curr] = true;
//		for(int i : map.get(curr)){
//			if(i != parent && helper(i, curr, map, visited) == false){return false;}
//		}
//		return true;
//	}

	
//	BFS
	private static boolean isValidTree(int[][] edges, int n) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		for(int i = 0; i<n; i++){
			map.put(i, new ArrayList<>());
		}
		for(int[] edge : edges){
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		queue.add(0);
		while(!queue.isEmpty()){
			int curr = queue.poll();
			if(visited[curr]){return false;}
			visited[curr] = true;
			for(int i : map.get(curr)){
				if(!visited[i]){queue.add(i);}
			}
		}
		for(boolean b : visited){
			if(!b){return false;}
		}
		return true;
	}

}
