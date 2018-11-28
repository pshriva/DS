package Hindex;

import java.util.Arrays;
//LCA both
public class Solution {
	public static void main(String[] args){
		int[] citations = {3,0,1,6,5};
		int hIndex = getHIndex(citations);
		System.out.println(hIndex);
	}

	
//	 If changing the elements of the array is allowed  or sorting is allowed
//	private static int getHIndex(int[] citations) {
//		Arrays.sort(citations);
//		int len = citations.length;
//		int hIndex = 0;
//		for(int i = 0; i< len; i++){
//			if(citations[i] >= len-i){
//				hIndex = Math.max(hIndex, len-i);
//			}
//		}
//		return hIndex;
//	}
	
//	If disrupting array is not allowed
	private static int getHIndex(int[] citations) {
		int len = citations.length;
		int[] citationsTable = new int[len + 1];
		for(int i = 0; i< len; i++){
			if(citations[i] > len){
				citationsTable[len] += 1;
			}else{
				citationsTable[citations[i]] += 1;
			}
		}
		int count = 0;
		for(int i = len; i>= 0; i--){
			count += citationsTable[i];
			if(count >= i){return i;}
		}
		return 0;
	}
}
