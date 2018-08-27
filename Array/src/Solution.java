
public class Solution {
	public static void main(String args[]) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSum = getMaxSubArraySum(arr);
		System.out.println(maxSum);
	}

	private static int getMaxSubArraySum(int[] arr) {
		int sum = arr[0];
		int maxSum = arr[0];
		for(int i = 1; i<arr.length; i++) {
			if(sum + arr[i] >= arr[i]) {
				sum = sum + arr[i];
				maxSum = Math.max(maxSum, sum);
			}else {
				sum = arr[i];
			}
		}
		return maxSum;
	}
}
