package ReverseWordsInAString;
//LCA
public class Solution {
	public static void main(String args[]){
		String str = "the sky is blue";
		String result = reverseWordsInString(str);
	}

	private static String reverseWordsInString(String str) {
		int i = 0;
		String result = new String();
		while(i < str.length()){
			while(i <str.length() && str.charAt(i) == ' '){i++;}
			int j = i;
			while(j < str.length() && str.charAt(j) != ' '){j++;}
			result = str.substring(i, j) + " " + result;
			i = j;
		}
		return result.trim();
	}
}
