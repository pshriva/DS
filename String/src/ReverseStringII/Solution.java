package ReverseStringII;
//LCA
public class Solution {
	public static void main(String [] args){
		String s = "abcdefg";
		int k = 2;
		String result = getReversedString(s, k);
		System.out.println(result);
	}

	private static String getReversedString(String s, int k) {
		char[] str = s.toCharArray();
		int i = 0;
		while(i < str.length){
			reverse(str, i, i+k-1);
			i = i + 2*k;
		}
		return String.valueOf(str);
	}

	private static void reverse(char[] str, int left, int right) {
		if(right >= str.length){right = str.length-1;}
		while(left < right){
			char temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			left++;
			right--;
		}
	}
}
