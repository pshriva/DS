package PowXN;

public class Solution {
	public static void main(String args[]){
		double x = 2;
		int n = 3;
		double ans = myPow(x,n);
		System.out.println(ans);
	}

	private static double myPow(double x, int n) {
		if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            } else {
                n = -n;
            }
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n /2) : x * myPow(x * x, n / 2);
	}
}
