package MinimumHeightTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// LCA
public class Solution {
	public static void main(String[] args){
		int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
		int n = 6;
		List<Integer> result = getMinimumHeightTreeCount(edges, n);
		System.out.println(result);
	}

	private static List<Integer> getMinimumHeightTreeCount(int[][] edges, int n) {
		if(n == 1){return new ArrayList<Integer>(Arrays.asList(0));}
		List<Integer> adlist[] = new ArrayList[n];
		for(int i = 0; i<n; i++){
			adlist[i] = new ArrayList<>();
		}
		for(int[] e : edges){
			adlist[e[0]].add(e[1]);
			adlist[e[1]].add(e[0]);
		}
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0; i<adlist.length; i++){
			if(adlist[i].size() == 1){
				leaves.add(i);
			}
		}
		int v = n;
		while(v > 2){
			v = v - leaves.size();
			List<Integer> currLeaves = new ArrayList<>();
			for(int i : leaves){
				int node = adlist[i].remove(0);
				adlist[node].remove(new Integer(i));
				if(adlist[node].size() == 1){
					currLeaves.add(node);
				}
			}
			leaves = currLeaves;
		}
		return leaves;
	}

//	private static List<Integer> getMinimumHeightTreeCount(int[][] edges, int n) {
//		if(n == 1)return new ArrayList<Integer>(Arrays.asList(0));
//		List<Integer> adjacencyList[] = new ArrayList[n];
//		for(int i = 0; i<n ;i++){
//			adjacencyList[i] = new ArrayList<>();
//		}
//		for(int[] e : edges){
//			adjacencyList[e[0]].add(e[1]);
//			adjacencyList[e[1]].add(e[0]);
//		}
//		List<Integer> leaves = new ArrayList<>();
//		for(int i=0 ; i< n; i++){
//			if(adjacencyList[i].size() == 1){
//				leaves.add(i);
//			}
//		}
//		int v = n;
//		while(v > 2){
//			v = v - leaves.size();
//			List<Integer> currentLeaves = new ArrayList<>();
//			for(int i : leaves){
//				int parent = adjacencyList[i].remove(0);
//				adjacencyList[parent].remove(new Integer(i));
//				if(adjacencyList[parent].size() == 1){
//					currentLeaves.add(parent);
//				}
//			}
//			leaves = currentLeaves;
//		}
//		return leaves;
//	}
}
