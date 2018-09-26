package Hindex;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int[] citations = {100};
		int hIndex = getHIndex(citations);
		System.out.println(hIndex);
	}

	private static int getHIndex(int[] citations) {
		Arrays.sort(citations);
		int len = citations.length;
		int hIndex = 0;
		for(int i = 0; i< len; i++){
			if(citations[i] >= len-i){
				hIndex = Math.max(hIndex, len-i);
			}
		}
		return hIndex;
	}
}
