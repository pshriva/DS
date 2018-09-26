package LongestPalindromicSubstring;

public class Solution {
//LCA
	public static void main(String[] args) {
		String str = "cbabd";
		String longestPalindrome = getLongestPalindrome(str);
		System.out.println(longestPalindrome);
	}

	private static String getLongestPalindrome(String str) {
		int[] max = new int[2];
		String result = "";
		if(str.length() <=1)return str;
		int[] index = new int[2];
		for(int i = 0; i<str.length(); i++){
			int[] index1 = getPalindromeLength(str, i, i);
			int[] index2 = getPalindromeLength(str, i-1, i);
			max = (max[1] - max[0] > index1[1] - index1[0]) ? (max[1] - max[0] > index2[1] - index2[0] ? max : index2) : (index1[1] - index1[0] > index2[1] - index2[0] ? index1 : index2);
		}
		return str.substring(max[0] + 1, max[1]);
	}

	private static int[] getPalindromeLength(String str, int left, int right) {
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
			left--;
			right++;
		}
		return new int[]{left, right};
	}

}
