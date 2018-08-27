package AddBinary;
//LCA
public class Solution {
	public static void main(String args[]) {
		String a = "1010";
		String b = "1011";
		String result = getBinarySum(a, b);
		System.out.println(result);
	}

	private static String getBinarySum(String a, String b) {
		int len1 = a.length() - 1;
		int len2 = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(len1 >= 0 || len2 >= 0 || carry != 0) {
			int one = len1 >= 0 ? a.charAt(len1) - '0' : 0;
			int two = len2 >= 0 ? b.charAt(len2) - '0' : 0;
			int sum = one + two + carry;
			carry = sum/2;
			sum = sum%2;
			sb.append(sum);
			len1--;
			len2--;
		}
		return sb.reverse().toString();
	}
}
