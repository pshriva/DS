package MissingRanges;

import java.util.*;
// LL
public class Solution {

	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75, 99};
//		int[] nums = {75, 76, 100};
//		int nums[] = {};
		int lower = 0;
		int upper = 99;
		List<String> ranges = getMissingRanges(nums, lower, upper);
		System.out.println(ranges);
	}

//	In one function
//	private static List<String> getMissingRanges(int[] nums, int lower, int upper) {
//		List<String> result = new ArrayList<>();
////		ASK FOR THIS CASE
//		if(lower == Integer.MAX_VALUE) return result;
//		if(nums == null || nums.length == 0){
//			if(lower == upper){result.add("" + lower);}
//			else{result.add("" + lower + "->" + upper);}
//			return result;
//		}
//		int next = lower;
//		for(int i = 0; i < nums.length; i++){
//			if(nums[i] > upper){break;}
//			if(nums[i] != next){
//				if(nums[i] - next == 1){
//					result.add("" + next);
//				}else{
//					result.add("" + next + "->" + Math.min(upper, nums[i]-1));
//				}
//			}
//			next = nums[i] + 1;
//			if(nums[i] == Integer.MAX_VALUE) return result;
//		}
//		if(next < upper){
//			result.add("" + next + "->" + upper);
//		}else if(next == upper){result.add("" + next);}
//		return result;
//	}
	
	
//	Dividing the function into 2
	private static List<String> getMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		int next = lower;
		for(int i = 0; i < nums.length; i++){
			if(lower == Integer.MAX_VALUE) return result;
			if(nums[i] > upper){break;}
			if(nums[i] != next){
				result.add(getRange(next, nums[i]-1));
			}
			next = nums[i] + 1;
//			We don't need to proceed after we have process Integer.MAX_VALUE in array
			if(nums[i] == Integer.MAX_VALUE) return result;
		}
		if(next <= upper){
			result.add(getRange(next, upper));
		}
		return result;
	}
	
	private static String getRange(int left, int right){
		return (right == left) ? ("" + left) : ("" + left + "->" + (right));
	}

}
