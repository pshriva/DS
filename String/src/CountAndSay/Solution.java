package CountAndSay;
// LCA
public class Solution {
	public static void main(String args[]) {
		int n = 3;
		String result = countAndSay(n);
		System.out.println(result);
	}

	private static String countAndSay(int n) {
		String result = "1";
		for(int i = 1; i<n; i++) {
			StringBuffer sb = new StringBuffer();
			int j = 0;
			while(j < result.length()) {
				int count = 1;
				while(j < (result.length() - 1) && result.charAt(j) == result.charAt(j+1)) {
					count++;
					j++;
				}
				sb.append(count).append(result.charAt(j));
				j++;
			}
			result = sb.toString();
		}
		return result;
	}
}
