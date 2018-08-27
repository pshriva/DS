package LongestPathDAG;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	int V;
	List<Integer> adjacencyList[];
	public Graph(int value) {
		this.V = value;
		adjacencyList = new ArrayList[value];
		for(int i = 0; i< value ; i++) {adjacencyList[i] = new ArrayList<>();}
	}
	public void createEdge(int i, int j) {
		if(!adjacencyList[i].contains(j)) {adjacencyList[i].add(j);}
	}
	public void display() {
		for(int i = 0; i < V; i++) {
			System.out.println(i + " : " + adjacencyList[i]);
		}
	}
	public int getLongestPath() {
		int maxPath = 0;
		int[] indegree = new int[V];
		int[] longestPathToNode = new int[V];
		for(int i = 0; i<V; i++) {
			for(int j : adjacencyList[i]) {
				indegree[j] += 1;
			}
		}
		for(int i = 0; i<V; i++) {
			if(indegree[i] == 0) {
				indegree[i] = -1;
				for(int j : adjacencyList[i]) {
					indegree[j] -= 1;
					longestPathToNode[j] = Math.max(longestPathToNode[j], longestPathToNode[i] + 1);
					maxPath = Math.max(maxPath, longestPathToNode[j]);
				}
			}
		}
		return maxPath;
	}
}
