package DecodeWays;

public class Solution {
	public static void main(String args[]){
		String code = "313";
		int ways = getTotalWaysToDecode(code);
		System.out.println(ways);
	}

	private static int getTotalWaysToDecode(String code) {
		if(code == null || code.length() == 0){return 0;}
		int[] dp = new int[code.length()+1];
		dp[0] = 1;
		dp[1] = code.charAt(0) == '0' ? 0 : 1;
		for(int i = 2; i<=code.length(); i++){
			int last = Integer.parseInt(code.substring(i-1, i));
			int secondLast = Integer.parseInt(code.substring(i-2, i));
			System.out.println(last + " " + secondLast);
			if(1 <= last && last <= 9){
				dp[i] += dp[i-1];
			}
			if(10 <= secondLast && secondLast <= 26){
				dp[i] += dp[i-2];
			}
		}
		return dp[code.length()];
	}
}
