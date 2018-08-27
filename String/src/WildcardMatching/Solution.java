package WildcardMatching;

//LCA
public class Solution {
	public static void main(String[] args) {
		String s = "adceb";
		String p = "*a*b";
		boolean isMatch = isMatch(s, p);
		System.out.println(isMatch);
	}

	private static boolean isMatch(String s, String p) {
		int len1 = 0;
		int len2 = 0;
		int starIndex = -1;
		int stringIndex = -1;
		while(len1 < s.length()) {
			if(len2 < p.length() && (s.charAt(len1) == p.charAt(len2) || p.charAt(len2) == '?')) {
				len1++;
				len2++;
			}else if(len2 <p.length() && p.charAt(len2) == '*') {
				starIndex = len2;
				stringIndex = len1;
				len2++;
			}else if(starIndex != -1){
				len2 = starIndex;
				len1 = stringIndex +1;
				stringIndex++;
			}else {return false;}
		}
		while(len2 < p.length() && p.charAt(len2) == '*') {len2++;}
		return len2 == p.length();
	}
	
}
