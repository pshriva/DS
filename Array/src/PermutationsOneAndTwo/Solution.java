package PermutationsOneAndTwo;

import java.util.*;
//LCA
public class Solution {
	public static void main(String []args){
		int[] arr = {1,2,3};
		List<List<Integer>> result = getAllPermutations(arr);
		System.out.println(result);
	}

	private static List<List<Integer>> getAllPermutations(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int  i = 0; i < arr.length; i++){
			Set<ArrayList<Integer>> current = new HashSet<>();
			for(List<Integer> l : result){
				for(int j = 0; j<l.size()+1; j++){
					l.add(j, arr[i]);
					current.add(new ArrayList<Integer>(l));
					l.remove(j);
				}
			}
			result = new ArrayList<List<Integer>>(current);
		}
		return result;
	}
}
