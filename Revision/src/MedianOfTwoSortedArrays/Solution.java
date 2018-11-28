package MedianOfTwoSortedArrays;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {1,3,8,9,10,12};
		int[] brr = {2,3,4,7,17};
		int median = getMedian(arr, brr);
	}

	private static int getMedian(int[] arr, int[] brr) {
		if(brr.length < arr.length){return getMedian(brr, arr);}
		
		return 0;
	}

}
