package GraphBasicOperations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	int V;
	List<Integer> adjacencyList[];
	public Graph(int value) {
		this.V = value;
		adjacencyList = new ArrayList[V];
		for(int i = 0 ; i<V; i++) {adjacencyList[i] = new ArrayList<Integer>();}
	}
	public void addEdge(int i, int j) {
		if(!adjacencyList[i].contains(j)){adjacencyList[i].add(j);}
		if(!adjacencyList[j].contains(i))adjacencyList[j].add(i);
	}
	public void display() {
		for(int i = 0; i< V; i++) {
			System.out.println("Vertex " + i + " : " + adjacencyList[i]);
		}
	}
	public void getBFS() {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while(!queue.isEmpty()) {
			int vertex = queue.remove();
			if(!visited[vertex]) {
				System.out.println(vertex);
				visited[vertex] = true;
			}
			for(int i : adjacencyList[vertex]) {
				if(!visited[i]) {queue.add(i);}
			}
		}
	}
	
	//Recursive
	public void getDFS() {
		boolean[] visited = new boolean[V];
		//for loop so as to catch all the nodes even in a disconnected graph
		for(int i = 0; i< V; i++) {
			if(!visited[i]) {getDFS(i, visited);}
		}
	}
	private void getDFS(int n, boolean []visited) {
		visited[n] = true;
		System.out.println(n);
		for(int i : adjacencyList[n]) {
			if(!visited[i]) {
				getDFS(i, visited);
			}
		}
	}
}
