package BuyAndSellStockOne;

public class Solution {
	public static void main(String args[]) {
		int[] arr = {7,1,5,3,0,6,4};
		int maxProfit = getMaxProfit(arr);
		System.out.println(maxProfit);
	}
	
	private static int getMaxProfit(int[] arr) {
		if(arr.length == 0) {return 0;}
		int CP = arr[0];
		int SP = arr[0];
		int maxProfit = 0;
		for(int i = 1; i<arr.length ; i++) {
			if(arr[i] < CP) {
				CP = arr[i];
				SP = arr[i];
			}else if(arr[i] > SP) {
				SP = arr[i];
			}
			maxProfit = Math.max(maxProfit, SP-CP);
		}
		
		return Math.max(maxProfit, SP-CP);
	}
}
