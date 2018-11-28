package PerfectSquares;

import java.util.*;

// LCA
public class Solution {
	public static void main(String []args){
		int n  = 1;
		int result = getMinimumNumSquares(n);
		System.out.println(result);
	}
	
// DP solution
//	private static int getMinimumNumSquares(int n) {
//		int[] dp = new int[n+1];
//		for(int i = 1; i<= n; i++){
//			int min = dp[i - 1];
//			for(int j = 2; j*j <= i; j++){
//				min = Math.min(dp[i - j*j], min);
//			}
//			dp[i] = min+1;
//		}
//		return dp[n];
//	}
	
// BFS solution
//	 Time limit exceeded but is a true one
	private static int getMinimumNumSquares(int n) {
		if(n == 0){return 0;}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int count = 0;
		while(!queue.isEmpty()){
			count++;
			int size = queue.size();

			for(int i = 0; i< size; i++){
				int curr = queue.poll();
//				let have curr = 12, then store, (12 - 1*1), (12 - 2*2), (12 - 3*3) in the queue and
//				increase the count after all the numbers at a level are computed
				for(int j = 1; j*j <= curr; j++){
					int diff = curr - j*j;
					if(diff == 0){return count;}
					queue.add(curr - j*j);
				}
			}
		}
		return count;
	}
}
