package MaximumSizeSubArraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {6,3,3,0,2,2,2};
		int k = 6;
		int maxSize = getMaximumSizeSubArray(arr, k);
		System.out.println(maxSize);
	}

	private static int getMaximumSizeSubArray(int[] arr, int k) {
		if(arr.length == 0) {return 0;}
		int maxSize = 0;
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i< arr.length; i++) {
			sum += arr[i];
			if(sum == k) {
				maxSize = i+1;
			}else if(map.containsKey(sum-k)) {maxSize = Math.max(maxSize, i-map.get(sum-k));}
			if(!map.containsKey(sum)) {map.put(sum, i);}
		}
		return maxSize;
	}

}
