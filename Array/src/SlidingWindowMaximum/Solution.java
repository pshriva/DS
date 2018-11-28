package SlidingWindowMaximum;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7, 8, 9};
//		int[] nums = {1,-1};
		int k = 3;
		int[] result = maxSlidingWindow(nums, k);
		for(int i : result){
			System.out.print(i + " ");
		}
	}
// LCA, Basic
//	private static int[] maxSlidingWindow(int[] nums, int k) {
//		if(nums == null || nums.length == 0){return nums;}
//		int[] result = new int[nums.length-k+1];
//		int max = Integer.MIN_VALUE;
//		int index = 0;
//		for(int i = 0; i < Math.min(k, nums.length); i++){
//			max = Math.max(max, nums[i]);
//		}
//		result[index++] = max;
//		for(int i = 0, j = k; j < nums.length; j++, i++){
//			System.out.println(nums[j]);
//			if(nums[i] != max){
//				max = Math.max(max, nums[j]);
//			}else{
//				max = findMax(nums, i+1, j);
//			}
//			result[index++] = max;
//		}
//		return result;
//	}
//
//	private static int findMax(int[] nums, int i, int j) {
//		int max = Integer.MIN_VALUE;
//		for(; i<= j; i++){
//			max = Math.max(max, nums[i]);
//		}
//		return max; 
//	}

	
	
	
	
	
	private static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0){return nums;}
		int[] maxFLeft = new int[nums.length];
		int[] maxFRight = new int[nums.length];
		int[] result = new int[nums.length - k + 1];
		maxFLeft[0] = nums[0];
		maxFRight[nums.length-1] = nums[nums.length - 1];
		for(int i = 1; i < nums.length; i++){
			maxFLeft[i] = (i%k == 0) ? nums[i] : Math.max(maxFLeft[i-1], nums[i]);
			int j = nums.length - i - 1;
			maxFRight[j] = (j%k == 0) ? nums[j] : Math.max(maxFRight[j+1], nums[j]);
		}
		int j = 0;
		for(int i = 0; i < result.length; i++){
			result[j++] = Math.max(maxFRight[i], maxFLeft[i+k-1]);
		}
		return result;
	}

//	private static int[] maxSlidingWindow(int[] nums, int k) {
//		if(nums == null || nums.length == 0)return nums;
//		int[] result = new int[nums.length-k+1];
//		Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b-a));
//		int m = 0;
//		for(int i = 0; i<k; i++){
//			queue.offer(nums[i]);
//		}
//		result[m++] = queue.peek();
//		int j = k;
//		for(int i = 0; j< nums.length; j++, i++){
//			queue.offer(nums[j]);
//			queue.remove(Integer.valueOf(nums[i]));
//			result[m++] = queue.peek();
//		}
//		return result;
//	}

}
