package BinaryNumberWithAlternatingBits;
//LCA
public class Solution {
	public static void main(String [] args){
		int num = 3;
		boolean result = hasAlternatingBits(num);
		System.out.println(result);
	}

	private static boolean hasAlternatingBits(int num) {
		int prev = -1;
		while(num != 0){
			int lastDigit = num & 1;
			if(lastDigit == prev){return false;}
			prev = lastDigit;
			num = num >> 1;
		}
		return true;
	}
}
