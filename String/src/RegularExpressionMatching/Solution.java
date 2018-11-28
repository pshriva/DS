package RegularExpressionMatching;

public class Solution {

	public static void main(String[] args) {
//		String s = "aab";
//		String p = "c*a*b";
		String s = "mississippi";
		String p = "mis*is*p*.";
		boolean match = findMatch(s, p);
		System.out.println(match);
	}

	private static boolean findMatch(String s, String p) {
		if (p == null || p.length() == 0) return (s == null || s.length() == 0);
        
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=2; j<=p.length(); j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
        }
        
        
         for (int i=1; i<=s.length(); i++) {
        	 for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
					dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }
        }
         
         for(int i = 0; i < dp.length; i++){
        	 for(int j = 0; j < dp[0].length; j++){
        		 char ch = dp[i][j] == true ? 'T' : 'F';
        		 System.out.print(ch + " ");
        	 }
        	 System.out.println();
         }
        return dp[s.length()][p.length()];
	}

}
