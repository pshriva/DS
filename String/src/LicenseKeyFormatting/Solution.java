package LicenseKeyFormatting;
//LCA
public class Solution {
	public static void main(String[] args){
		String S = "5F3Z-2e-9-w";
		int K = 4;
		String result = getFormattedString(S, K);
		System.out.println(result);
	}

	private static String getFormattedString(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = s.length()-1; i>= 0; i--){
			char ch = s.charAt(i);
			if(ch == '-'){continue;}
			if(count == k){
				sb.append("-");
				count = 0;
			}
			sb.append(Character.toUpperCase(ch));
			count++;
		}
		return sb.reverse().toString();
	}
}
