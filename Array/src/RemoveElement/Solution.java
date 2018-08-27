package RemoveElement;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {0,1,2,2,3,0,4,2,2,2,5,2,4};
		int k = 2;
		int len = removeK(arr, k);
		for(int i = 0; i<len; i++) {
			System.out.println(arr[i]);
		}
	}

//	private static int removeK(int[] arr, int k) {
//		int j = 0;
//		int i = 0;
//		while(j < arr.length) {
//			while(j < arr.length && arr[j] == k) {j++;}
//			if(j <arr.length)arr[i++] = arr[j++];
//		}
//		return i;
//	}
	private static int removeK(int[] arr, int k) {
		int j = 0;
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] != k) {arr[j++] = arr[i];}
		}
		return j;
	}

}
