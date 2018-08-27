package RemoveDuplicatesFromSortedArray;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,2,2,3,3,4,4,5,6,6};
		int length = removeDuplicates(arr);
		for(int i = 0; i<length; i++) {
			System.out.println(arr[i]);
		}
	}

	//original, LC accepted
	private static int removeDuplicates(int[] arr) {
		if(arr.length <= 1) {return arr.length;}
		int j = 0;
		int i = 0;
		while(j < arr.length) {
			while(j<arr.length-1 && arr[j] == arr[j+1]) {j++;}
			arr[i++] = arr[j++];
		}
		return i;
	}

}
