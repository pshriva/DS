package MinimumDistinctLocations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {7,3,3,1,3,4,1,8,7};
		int minimumDistinctLocations = getMinimumDistinctLocations(arr);
		System.out.println(minimumDistinctLocations);
	}

	private static int getMinimumDistinctLocations(int[] arr) {
		Set<Integer> distinctLocations = new HashSet<>();
		Map<Integer,Integer> map = new HashMap<>();
		int left = 0;
		int minDestinations = arr.length;
		for(int i : arr) {distinctLocations.add(i);}
		for(int i = 0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {map.put(arr[i], map.get(arr[i]) + 1);}
			else {map.put(arr[i], 1);}
			if(map.size() == distinctLocations.size()) {
				while(map.containsKey(arr[left]) && map.get(arr[left]) > 1) {
					map.put(arr[left], map.get(arr[left]) - 1);
					left++;
				}
				minDestinations = Math.min(minDestinations, i-left+1);
			}
			
		}
		return minDestinations;
	}

}
