package BurstBalloons;

public class Solution {

	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		int maxCoins = burstBalloons(nums);
	}

	private static int burstBalloons(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		
		for(int len = 1; len <= nums.length ; len++){//marking len, 1, 2, 3, 4
			for(int i = 0; i<= nums.length - len; i++){// if len = 1, then iterate - 5-1 = 4 times, 
													   // if len = 2, then iterate- 5-2 = 3 times
													  // if len = 3, then iterate- 5-3 = 2 times
				int j = i+len-1; // these many elements to iterate take ith element as last balloon to burst
								// Eg, if len = 3, then we have to take ((i-len+1) =2 =>  0 to 2 indexed elements in the k loop)
				for(int k = i ; k<= j; k++){
					int leftSum = 1;
					int rightSum = 1;
					if(i != 0){leftSum = nums[i-1];}
					if(j != nums.length - 1){rightSum = nums[j+1];}
					
					int beforeSum = 0;
					int afterSum = 0;
//					if it is not the 1st element in the considered subarray, means we already have a before calculated in our dp
					if(i != k){
						beforeSum = dp[i][k-1];
					}
					if(j != k){
						afterSum = dp[k+1][j];
					}
					
					dp[i][j] = Math.max(dp[i][j], beforeSum + leftSum*nums[k]*rightSum + afterSum);
				}
			}
		}
		return dp[0][nums.length - 1];
	}

}
