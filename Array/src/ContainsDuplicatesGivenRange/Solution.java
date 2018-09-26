package ContainsDuplicatesGivenRange;
/*
 * Given an array of length N containing elements between (0 - (N-1)),
 * find all the duplicate elements in it
 */
public class Solution {
	public static void main(String args[]){
		int[] arr = {1,2,3,4,5,5,1};
		printDuplicates(arr);
	}

	private static void printDuplicates(int[] arr) {
		for(int i = 0; i< arr.length; i++){
			if(arr[Math.abs(arr[i])] > 0){
				arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
			}else{
				System.out.println(Math.abs(arr[i]));
			}
		}
	}
}
