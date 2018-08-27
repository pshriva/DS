package Subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String args[]) {
		int[] nums = {1,2,3};
		List<List<Integer>> result = getAllSubsets(nums);
		System.out.println(result);
	}

	private static List<List<Integer>> getAllSubsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int i : nums) {
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> l : result) {
				List<Integer> curr = new ArrayList<>(l);
				curr.add(i);
				temp.add(curr);
			}
			result.addAll(temp);
		}
		return result;
	}

	
	
	
//	private static List<List<Integer>> getAllSubsets(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<Integer>());
//        for(int val : nums){
//            List<List<Integer>> temp = new ArrayList<>();
//            for(List<Integer> ls : result){
//                List<Integer> curr = new ArrayList<Integer>(ls);
//                curr.add(val);
//                temp.add(curr);
//            }
//            result.addAll(temp);
//        }
//        return result;
//	}
}
