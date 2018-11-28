package MissingNumber;

import java.util.*;

public class Solution {
//All 3 solutions are LCA
	public static void main(String[] args) {
		int[] arr = {9,6,4,2,3,5,7,0,1};
		int num = findMissingNumber(arr);
		System.out.println(num);
		
		String s = "A B C D E ";
		Queue<String> queue = new LinkedList<>(new ArrayList<String>(Arrays.asList(s.split(" "))));
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		
	}

	private static int findMissingNumber(int[] arr) {
		int res = arr.length;
//		Doing a XOR with every number 2 times, (for index anda for element) replaces the value of res to be same,
//		length = 3 (say), and element - 0, 1, 3, to to perform xor- we have - 0,1,3,0, 1,2
//		XOR for 0,0, 1, 1 cancel out. Left - > 2, 3, zor with 3 gives 0 (since same numbers XOR is 0), 
//		then 0 with 2 gives 2, which is the missing number
		for(int i = 0; i< arr.length ; i++){
			res = res^i;
			res = res^arr[i];
		}
		return res;
	}
}
/*
 * 1. Do the XOR as above,
 * 2. take sum of all numbers from 0 to n-1 using sum of all natural numbers formula, 
 * then keep subtracting it from each element, what is left in the suma t the end is the result
 * 3.Sort the array, perform a binary search and see if the mid != arr[mid], then high = mid, else low = mid+1
 */
