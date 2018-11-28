package Subsets;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> list = getSubsets(nums);
		System.out.println(list);
	}

	private static List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		list.add(new ArrayList<>());
		if(nums == null || nums.length == 0){return list;}
		for(int i = 0; i<nums.length; i++){
			List<List<Integer>> curr = new ArrayList<>();
			for(List<Integer> l : list){
				List<Integer> temp = new ArrayList<>(l);
				temp.add(nums[i]);
				curr.add(temp);
			}
			list.addAll(curr);
		}
		return list;
	}

}
