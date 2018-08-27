package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String args[]) {
		int arr[] = {-1, 0, 1, 2, -1, -4};
		int sum = 0;
		List<List> result = threeSum(arr, sum);
		for(List l : result) {
			System.out.println(l);
		}
	}

	private static List threeSum(int[] nums, int sum) {
		List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){continue;}
            int target = -nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[start] + nums[end] == target){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]){start++;}
                    while(start < end && nums[end] == nums[end+1]){end--;}
                }else if(nums[start] + nums[end] < target){start++;}
                else{end--;}
            }
        }
        return result;
	}
}
