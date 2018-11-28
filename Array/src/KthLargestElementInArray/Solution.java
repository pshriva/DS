package KthLargestElementInArray;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		int element = getKthLargetElement(arr);
		System.out.println(element);
	}

	private static int getKthLargetElement(int[] arr) {
		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new PriorityQueue<>();
		queue.offer(3);
		queue.offer(1);
		queue.offer(2);
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		return 0;
	}

}
