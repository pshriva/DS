           package SortByFrequencyAndThenByNumber;

import java.util.*;
//First sort by frequency and then by value, both increasing
public class Solution {
	public static void main(String[] args){
		int []arr = {4,5,6,5,4,3}; //ans - 3,6,4,4,5,5
		sortByFrequencyAndCount(arr);
	}
	/*
	 * Better - 
	 * 1. Sort the array
	 * 2. Create - Map<Integer, List<Integer>>, to store the frequency and list of values that occur key many times
	 * put back in array
	 */
	
	
// Brute Force
	private static void sortByFrequencyAndCount(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Map.Entry<Integer, Integer>> queue = 
				new PriorityQueue<>((a, b)->(a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue()));
		for(int i = 0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> m : map.entrySet()){
			queue.add(m);
		}
		int k = 0;
		while(!queue.isEmpty()){
			Map.Entry<Integer, Integer> cur = queue.poll();
			for(int i = 0; i<cur.getValue(); i++){
				arr[k++] = cur.getKey(); 
			}
		}
		for(int i : arr){
			System.out.println(i);
		}
	}
}

