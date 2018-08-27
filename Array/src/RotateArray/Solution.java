package RotateArray;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {9,7,8,3,4,11,100};
		int k = 3;
		getReversedArray(arr, k);
//		for(int i : arr) {System.out.println(i);}
	}

//	private static void getReversedArray(int[] arr, int k) {
//		k = k%arr.length;
//		reverse(0, arr.length-k);
//		reverse(arr.length-k+1, arr.length-1);
//	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void getReversedArray(int[] arr, int k) {
		k = k%arr.length;
		reverseArray(arr, 0, k-1);
		reverseArray(arr, k, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

}
