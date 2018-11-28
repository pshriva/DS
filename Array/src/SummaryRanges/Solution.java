package SummaryRanges;

import java.util.*;

public class Solution {
// LCAA
	public static void main(String[] args) {
//		int[] nums = {0,1,2,4,5,6,7};
		int[] nums = {0,2,3,4,6,8,9};
		List<String> result = getRanges(nums);
		System.out.println(result);
	}

	private static List<String> getRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if(nums == null || nums.length == 0){return result;}
		for(int i = 0; i<nums.length; i++){
			int start = nums[i];
			while(i+1 < nums.length && nums[i]+1 == nums[i+1]){
				i++;
			}
			result.add(getRange(start, nums[i]));
		}
		return result;
	}

	private static String getRange(int prev, int i) {
		return i == prev ? ("" + prev) : ("" + prev +"->" + i);
	}

}
