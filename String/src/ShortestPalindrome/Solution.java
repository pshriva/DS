package ShortestPalindrome;

public class Solution {

	public static void main(String[] args) {
//		String s = "abcdabcabcdf";
//		String s = "abcdabeabf";
//		String s = "abcdeabfabc";
//		String s = "aabcadaabe";
//		String s =  "aacecaaa";
		String s = "abcd";
//		int[] table = new int[s.length()];
//		getIndex(s, table);
//		for(int i = 0; i<s.length(); i++){
//			System.out.print(s.charAt(i) + " ");
//		}
//		System.out.println();
//		for(int i : table){
//			System.out.print(i + " ");
//		}
//		
		String palindrome = getSmallestPalindrome(s);
		System.out.println(palindrome);
	}
	
//	Finding out what are the prefixes in the original string that are also the suffixes, and then whatever is left, that is where we have to start creating the new string
	private static String getSmallestPalindrome(String s) {
		String curr = s + "#" + new StringBuilder(s).reverse().toString();
		int[] table = new int[curr.length()];
		getIndex(curr, table);
//		for(int i = 0; i<curr.length(); i++){
//			System.out.print(curr.charAt(i) + " ");
//		}
//		System.out.println();
		for(int i : table){
			System.out.print(i + " ");
		}
		return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	}

	private static void getIndex(String s, int[] table) {
		int index = 0;
		for(int i = 1; i<s.length(); i++){
			if(s.charAt(index) == s.charAt(i)){
				table[i] = table[i-1] + 1;
				index++;
			}else{
//				Good explaination for this is  aabaabaaa
				index = table[i-1];
				while(index > 0 && s.charAt(index) != s.charAt(i)){
					index = table[index - 1];
				}
				if(s.charAt(index) == s.charAt(i)){
	                index ++ ;
	            }
	            table[i] = index;
			}
		}
	}

}
