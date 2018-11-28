package MaximumProductOfWordLengths;

import java.util.*;
//LCA
public class Solution {
	public static void main(String args[]){
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		int product = maxProduct(words);
		System.out.println(product);
	}

	/**
	 * 		The soultion is calcuated by doing a product of the length of
	 *         each string to every other string. Anyhow the constraint given is
	 *         that the two strings should not have any common character. This
	 *         is taken care by creating a unique number for every string. Image
	 *         a an 32 bit integer where 0 bit corresponds to 'a', 1st bit
	 *         corresponds to 'b' and so on.
	 * 
	 *         Thus if two strings contain the same character when we do
	 *         "AND" the result will not be zero and we can ignore that case.
	 */
	private static int maxProduct(String[] words) {
		if(words == null || words.length <= 1){return 0;}
		int maxProduct = 0;
		int[] bitsOR = new int[words.length];
		for(int i = 0; i<words.length ;i++){
			int or = 0;
			for(int j = 0; j < words[i].length(); j++){
				or = or|(1<<( words[i].charAt(j) - 'a'));
			}
			bitsOR[i] = or;
		}
		
		for(int i = 0; i< words.length-1; i++){
			for(int j = i+1; j<words.length; j++){
				if((bitsOR[i]&bitsOR[j]) == 0){
					maxProduct = Math.max(maxProduct, words[i].length()*words[j].length());
				}
			}
		}
		return maxProduct;
	}
}
