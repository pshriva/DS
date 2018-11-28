package DivideTwoIntegers;

public class Solution {
	public static void main(String args[]) {
		int dividend = -2147483648;
		int divisor = 1;
		int quotient = getQuotient(dividend, divisor);
		System.out.println("Quotient is " + quotient);
	}

	
//	LCA
	private static int getQuotient(int dividend, int divisor) {
		if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int flag = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        if(divisor > 0)
            divisor = -divisor;
        if(dividend > 0)
            dividend = -dividend;
        int result = 0;
        while(dividend <= divisor){
            int count = 1, tempDivisor = divisor;
            while(dividend - tempDivisor <= tempDivisor){
                count <<= 1;
                tempDivisor <<= 1;
            }
            result += count;
            dividend -= tempDivisor;
        }
        return flag * result;
	}

//	private static int getQuotient(int dividend, int divisor) {
//		if(dividend == 0) {return 0;}
//		if(divisor == 0) {return Integer.MIN_VALUE;}
//		int quotient = 0;
//		boolean isPositive = ((dividend < 0) ^ (divisor < 0)) ? false : true;
//		
//		dividend = Math.abs(dividend);
//		divisor = Math.abs(divisor);
//		while((dividend - divisor) >= 0) {
//			dividend = (dividend - divisor);
//			quotient++;
//		}
//		return (isPositive ? quotient : -quotient);
//	}
	
	
}
