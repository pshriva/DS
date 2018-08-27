package LongestPalindromicSubstring;
// This is wrong solution, rightis in my LC
public class Solution {
	public static void main(String[] args) {
		String s = "babadwe";
		System.out.println(s.substring(1, 4));
		//String result = longestPalindrome(s);
//		System.out.println(result);
	}

	private static String longestPalindrome(String s) {
		// TODO Auto-generated method stub
		String result = "";
		for(int i = 0; i<s.length(); i++) {
			String current = getLongestPalindrome(s, i);
			result = result.length() >= current.length() ? result : current;
		}
		return result;
	}

	private static String getLongestPalindrome(String s, int i) {
		// TODO Auto-generated method stub
		if(i ==0 || i == s.length() - 1) {return "";}
		System.out.println("Index  " + i);
		int left = i-1;
		int right = i+1;
		while(left >= 0 && right < s.length()) {
			System.out.println("While index " + i + " " + s.charAt(left) + ": " + s.charAt(right));
			if(s.charAt(left) == s.charAt(right)) {
				System.out.println("String in if is " + s.substring(left, right+1));
				left--;
				right++;
			}else {
				return (right - left >=2) ? s.substring(left+1,right) : "";
			}
		}
		return "";
	}
}
