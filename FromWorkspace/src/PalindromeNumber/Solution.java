package PalindromeNumber;


public class Solution {
	public static void main(String args[]) {
		int num = 123321;
		System.out.println(isPalindrome(num));
	}

	private static boolean isPalindrome(int num) {
		if(num < 0) {return false;}
		int div = 1;
		while(num/div > 10) {div *= 10;}
		while(num != 0) {
			int left = num/div;
			int right = num%10;
			if(left != right) {return false;}
			num = (num % div) / 10;
			div = div / 100;
		}
		return true;
	}
}
