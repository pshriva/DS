package MedianOfTwoSortedArrays;
//https://www.youtube.com/watch?v=LPFhl65R7ww
//LCA
public class Solution {
	public static void main(String args[]){
//		int[] arr = {1,3,8,9,10,12};
//		int[] brr = {2,3,4,7,17,19};
		int[] arr = {1,3};
		int[] brr = {2};
		double median = getMedianOfSortedArrays(arr, brr);
		System.out.println(median);
	}

	private static double getMedianOfSortedArrays(int[] arr, int[] brr) {
		if(arr.length > brr.length){return getMedianOfSortedArrays(brr, arr);}
		int len1 = arr.length;
		int len2 = brr.length;
		int left = 0;
		int right = len1;
		while(left <= right){
			System.out.println("left " + left  + " right " + right);
			int m1 = (left+right)/2;
			int m2 = (len1 + len2 + 1)/2 - m1;
			int maxLeftX = m1 == 0 ? Integer.MIN_VALUE : arr[m1-1];
			int minRightX = m1 == len1 ? Integer.MAX_VALUE : arr[m1];
			int maxLeftY = m2 == 0 ? Integer.MIN_VALUE : brr[m2-1];
			int minRightY = m2 == len2 ? Integer.MAX_VALUE : brr[m2];
			System.out.println("maxLeftX " + maxLeftX + " minRightX " + minRightX);
			System.out.println("maxLeftY " + maxLeftY + " minRightY " + minRightY);
			if(maxLeftX <= minRightY && maxLeftY <= minRightX){
				if((len1 + len2)%2 == 0){
					return ((double)Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY))/2;
				}else{
					System.out.println("Now returning");
					return (double)Math.max(maxLeftY, maxLeftX);
				}
			}else if(maxLeftX > minRightY){
				right = m1 - 1;
			}else{
				left = m1 + 1;
			}
		}
		return -1;
	}
}
