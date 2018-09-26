package ArrayPartitionI;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] arr = {1,4,3,2};
		int sum = getMinimumSum(arr);
		System.out.println(sum);
	}

	private static int getMinimumSum(int[] arr) {
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i< arr.length; i+=2){
			sum += arr[i];
		}
		return sum;
	}

}
