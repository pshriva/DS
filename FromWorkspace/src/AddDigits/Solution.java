package AddDigits;

public class Solution {
	public static void main(String args[]){
		int number = 991;
		int result = getSumOfDigit(number);
		System.out.println(result);
	}

	private static int getSumOfDigit(int number) {
		while(number >= 10){
			int sum = 0;
			while(number > 0){
				sum = sum + number%10;
				number = number/10;
			}
			number = sum;
		}
		return number;
	}
}
