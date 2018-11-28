package NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int n = 9;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {1, 3}, {5, 6}, {7, 8}};
		int components = getConnectedComponents(n, edges);
		System.out.println(components);
	}

//	Using UF way
	private static int getConnectedComponents(int n, int[][] edges) {
		int count = n;
		int[] components = new int[n];
		for(int i = 0; i<n; i++){
			components[i] = i;
		}
		for(int i = 0; i< edges.length; i++){
			int e1 = edges[i][0];
			int e2 = edges[i][1];
			int connE1 = getConnection(e1, components);
			int connE2 = getConnection(e2, components);
			if(connE1 != connE2){
				count--;
				components[connE1] = connE2;
			}
		}
		return count;
	}

	private static int getConnection(int e, int[] component) {
		while(e != component[e]){
			e = component[component[e]];
		}
		return e;
	}

	
//	A classic DFS approach, TC - O(E+V), SC - O(n)
//	private static int getConnectedComponents(int n, int[][] edges) {
//		List<List<Integer>> list = new ArrayList<>();
//		for(int i = 0; i<n; i++){
//			list.add(0, new ArrayList<>());
//		}
//		for(int[] edge : edges){
//			list.get(edge[0]).add(edge[1]);
//			list.get(edge[1]).add(edge[1]);
//		}
//		boolean visited[] = new boolean[n];
//		int count = 0;
//		for(int i = 0; i<n; i++){
//			if(!visited[i]){
//				dfs(i, list, visited);
//				count++;
//			}
//		}
//		return count;
//	}
//
//	private static void dfs(int i, List<List<Integer>> list, boolean[] visited) {
//		for(int v : list.get(i)){
//			if(!visited[v]){
//				visited[v] = true;
//				dfs(v, list, visited);
//			}
//		}
//	}

}
