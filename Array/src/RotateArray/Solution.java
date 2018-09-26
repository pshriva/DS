package RotateArray;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int k = 3;
		getReversedArray(arr, k);
		for(int i : arr) {System.out.println(i);}
	}

	private static void getReversedArray(int[] arr, int k) {
		k = k%arr.length;
		reverse(arr, 0, arr.length-1-k);
		reverse(arr, arr.length-k, arr.length-1);
		reverse(arr, 0, arr.length-1);
	}

	private static void reverse(int[] arr, int left, int right) {
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	private static void getReversedArray(int[] arr, int k) {
//		k = k%arr.length;
//		reverseArray(arr, 0, k-1);
//		reverseArray(arr, k, arr.length-1);
//		reverseArray(arr, 0, arr.length-1);
//	}
//
//	private static void reverseArray(int[] arr, int start, int end) {
//		while(start < end) {
//			int temp = arr[start];
//			arr[start] = arr[end];
//			arr[end] = temp;
//			start++;
//			end--;
//		}
//	}

}
