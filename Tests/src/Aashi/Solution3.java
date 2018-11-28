package Aashi;
//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class Solution3 {

	public static void main(String[] args) {
		int a[] = {10,8,7,6,5};
		int p =  maxProfit(a);
		System.out.println(p);
	}
	
	public static int maxProfit(int[] prices) {
        if(prices.length == 0){return 0;}
        int CP = prices[0];
        int SP = prices[0];
        int profit = 0;
        for(int i = 0; i<prices.length; i++){
            if(prices[i] < CP){
                profit = Math.max(profit, (SP-CP));
                CP = prices[i];
                SP = prices[i];
            }else{
                if(prices[i] > SP){
                    SP = prices[i];
                    profit = Math.max(profit, (SP-CP));
                }
            }
        }
        if(profit == 0){return -1;}
        return Math.max(profit, SP-CP);
    }

}
