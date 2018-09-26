package AddStrings;
//LCA
public class Solution {
	public static void main(String args[]){
		String num1 = "920";
		String num2 = "92";
		String sum = getSum(num1, num2);
		System.out.println(sum);
	}
	private static String getSum(String num1, String num2) {
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		while(i >= 0 || j >= 0 || carry != 0){
			sum = (i>=0  ? num1.charAt(i) - '0' : 0)
					+ (j >=0 ? num2.charAt(j) - '0' : 0)
					+ carry;
			carry = sum/10;
			sb.insert(0, sum%10);
			i--;
			j--;
		}
		return sb.toString();
	}
}
