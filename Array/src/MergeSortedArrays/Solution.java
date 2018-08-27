package MergeSortedArrays;
//LCA
public class Solution {
	public static void main(String args[]) {
		int[] arr1 = {1,2,3,0,0,0};
		int[] arr2 = {2,5,6};
		int m = 3;
		int n = 3;
		mergeArrays(arr1, m, arr2, n);
		for(int i : arr1) {
			System.out.println(i);
		}
	}

	private static void mergeArrays(int[] arr1, int m, int[] arr2, int n) {
		if(n == 0) {return;}
		int end = m + n - 1;
		m--;
		n--;
		while(m >= 0 && n >= 0) {
			if(arr1[m] >= arr2[n]) {
				arr1[end] = arr1[m];
				m--;
			}else {
				arr1[end] = arr2[n];
				n--;
			}
			end--;
		}
		while(m >= 0) {
			arr1[end--] = arr1[m--];
		}
		while(n >= 0) {
			arr1[end--] = arr2[n--];
		}
	}
}
