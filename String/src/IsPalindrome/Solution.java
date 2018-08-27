package IsPalindrome;

public class Solution {
	public static void main(String args[]) {
		String s = "Hellolleh";
		System.out.println(isPalindrome(s));
	}

	private static boolean isPalindrome(String s) {
		if(s.length() <= 1) {return true;}
//		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		char[] sa = s.toCharArray();
		while(left < right) {
			while(left < right && !isAlphanumeric(sa[left])) {left++;}
			while(left < right && !isAlphanumeric(sa[right])) {right--;}
			if(Character.toLowerCase(sa[left]) != Character.toLowerCase(sa[right])) {return false;}
			left++;
			right--;
		}
		return true;
	}

	private static boolean isAlphanumeric(char ch) {
		return ((ch >= 'a' && ch <= 'z') ||
				(ch >= '0' && ch <= '9') ||
				ch>= 'A' && ch <= 'Z');
	}
}
