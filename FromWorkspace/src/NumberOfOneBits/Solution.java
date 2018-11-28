package NumberOfOneBits;
//LCA both
public class Solution {
	public static void main(String args[]){
		int num = 11;
		int result = getNumberOfOneBits(num);
		System.out.println(result);
	}

//	private static int getNumberOfOneBits(int num) {
//		int count = 0;
//		while(num != 0){
//			count = count + (num&1);
//			num >>>= 1;
//		}
//		return count;
//	}
	
//	or
/*
 * Think of a number in binary n = XXXXXX1000, n - 1 is XXXXXX0111. n & (n - 1) will be XXXXXX0000 which is just cancel the last 1
 */
	private static int getNumberOfOneBits(int n) {
		int count = 0;
		while( n != 0){
			n = n&(n-1);
            count++;
		}
		return count;
	}
}
