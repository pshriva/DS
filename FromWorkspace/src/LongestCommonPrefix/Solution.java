package LongestCommonPrefix;

public class Solution {

	public static void main(String[] args) {
		String [] str = {"ageeks", "geaekforgeeks","gee", "geeksforgeeksforgeeks"};
		String prefix = getLongestCommonPrefix(str);
		System.out.println(prefix);
	}

	private static String getLongestCommonPrefix(String[] str) {
		String smallest = str[0];
		for(String s : str) {
			if(s.length() < smallest.length()) {smallest = s;}
		}
		for(int i = 0; i<smallest.length(); i++) {
			for(String s : str) {
				if(s.charAt(i) != smallest.charAt(i)) {return smallest.substring(0, i);}
			}
		}
		return smallest;
	}

}
