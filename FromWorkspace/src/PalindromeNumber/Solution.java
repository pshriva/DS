package PalindromeNumber;


public class Solution {
	public static void main(String args[]) {
		int num = 1001;
		System.out.println(isPalindrome(num));
	}
	
	private static boolean isPalindrome(int num) {
		if(num < 0) {return false;}
		int div = 1;
		while(num/div >= 10) {div *= 10;}
		while(num != 0) {
			System.out.println(num);
			int left = num/div;
			int right = num%10;
			System.out.println("Lf " + left + " rt " + right);
			if(left != right) {
				return false;
			}
			num = (num % div) / 10;
			div = div / 100;
		}
		return true;
	}
}
