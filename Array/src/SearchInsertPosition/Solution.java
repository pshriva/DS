package SearchInsertPosition;
// LCA
public class Solution {

	public static void main(String[] args) {
		int[] arr = {1,3,6,8};
		int k = 7;
		int index = getIndex(arr, k);
		System.out.println(index);
	}

	private static int getIndex(int[] arr, int k) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right){
			int mid = left + (right-left)/2;
			if(arr[mid] == k){return mid;}
			else if(arr[mid] < k){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return left;
	}

}
