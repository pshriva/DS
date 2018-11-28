package WiggleSort;

import java.util.*;
//LL
public class Solution {

	public static void main(String[] args) {
		int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
		wiggleSort(arr);
		for(int i : arr){System.out.print(i + " ");}
	}
// (nlogn) + O(n) still for the for loop
//	private static void wiggleSort(int[] arr) {
//		Arrays.sort(arr);
//		for(int i  = 2 ; i< arr.length ; i+=2){
//			int temp = arr[i-1];
//			arr[i-1] = arr[i];
//			arr[i] = temp;
//		}
//	}
	
	
//	O(n)
	private static void wiggleSort(int[] arr) {
		for(int i = 0; i< arr.length-1; i++){
			if(i%2 == 0){
//				has to be smaller
				if(arr[i] > arr[i+1]){
					swap(arr, i, i+1);
				}
			}else{
				if(arr[i] < arr[i+1]){
					swap(arr, i, i+1);
				}
			}
		}
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;
	}

}
