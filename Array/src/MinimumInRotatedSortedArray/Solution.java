package MinimumInRotatedSortedArray;
//LCA
public class Solution {
	public static void main(String[] args) {
//		int[] arr = {4,5,6,7,-5,-3,-2,-1,0,1,2};
		int[] arr = {3,1,2};
		int minimum = getMinimum(arr);
		System.out.println(minimum);
	}

	//LCA
//	private static int getMinimum(int[] arr) {
//		int left = 0;
//		int right = arr.length - 1;
//		while(left < right){
//			int mid = left + (right-left)/2;
//			if(mid-1 >=0 && arr[mid-1] > arr[mid]){return arr[mid];}
//			if(arr[right] < arr[mid]){
//				left = mid+1;
//			}else{right = mid-1;}
//		}
//		return arr[left];
//	}
	
	//LCA
	private static int getMinimum(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right){
			int mid = left + (right-left)/2;
			if(arr[right] < arr[mid]){
				left = mid+1;
			}else{right = mid;}
		}
		return arr[left];
	}
}
