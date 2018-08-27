package MultiplyStrings;
//LCA
public class Solution {
	public static void main(String args[]) {
		String num1 = "000001";
		String num2 = "0001";
		String product = getProduct(num1, num2);
		System.out.println(product);
	}

	private static String getProduct(String num1, String num2) {
		int[] product = new int[num1.length() + num2.length()];
		int k = product.length;
		for(int i = num2.length() - 1; i>= 0; i--) {
			k--;
			int m = k;
			int carry = 0;
			for(int j = num1.length() - 1; j >= 0; j--) {
				int sum = product[m] + ((num2.charAt(i) - '0') * (num1.charAt(j) - '0')) + carry;
				carry = sum/10;
				sum = sum%10;
				product[m] = sum;
				m--;
			}
			product[m] = carry;
			
		}
		k = 0;
		while(k <product.length && product[k] == 0) {k++;}
		StringBuffer sb = new StringBuffer();
		for(int i = k ; i <product.length; i++) {
			sb.append(product[i]);
		}
		return sb.length()  == 0 ? "0" : sb.toString();
	}
}
