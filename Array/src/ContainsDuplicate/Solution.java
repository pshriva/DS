package ContainsDuplicate;

import java.util.Arrays;
//LCA
public class Solution {
	public static void main(String args[]){
		int [] arr = {1, 2, 3, 1, 3, 6, 6};
		System.out.println(containsDuplicates(arr));
	}

	private static boolean containsDuplicates(int[] arr) {
		Arrays.sort(arr);
		for(int i = 1; i<arr.length; i++){
			if(arr[i-1] == arr[i]){return true;}
		}
		return false;
	}
	
}
