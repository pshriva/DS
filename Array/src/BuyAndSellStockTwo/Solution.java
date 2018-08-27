package BuyAndSellStockTwo;
//LCA
public class Solution {
	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		int maxProfit = getMaxProfit(arr);
		System.out.println(maxProfit);
	}

	private static int getMaxProfit(int[] arr) {
		if(arr.length == 0) {return 0;}
		int maxProfit = 0;
		for(int i = 1; i< arr.length; i++) {
			if(arr[i-1] < arr[i]) {
				maxProfit = maxProfit + (arr[i] - arr[i-1]);
			}
		}
		return maxProfit;
	}
}
