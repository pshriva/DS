package DivideTwoIntegers;

public class Solution {
	public static void main(String args[]) {
		int dividend = -43;
		int divisor = 5;
		int quotient = getQuotient(dividend, divisor);
		System.out.println("Quotient is " + quotient);
	}

	private static int getQuotient(int dividend, int divisor) {
		if(dividend == 0) {return 0;}
		if(divisor == 0) {return Integer.MIN_VALUE;}
		int quotient = 0;
		boolean isPositive = ((dividend < 0) ^ (divisor < 0)) ? false : true;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while((dividend - divisor) >= 0) {
			dividend = (dividend - divisor);
			quotient++;
		}
		return (isPositive ? quotient : -quotient);
	}
}
