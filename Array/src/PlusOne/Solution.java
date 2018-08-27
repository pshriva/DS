package PlusOne;
//LCA
public class Solution {
	public static void main(String args[]) {
		int[] arr = {4,3,2,1};
		int[] result = getSum(arr);
		for(int i : result) {System.out.print(i + " ");}
	}

	private static int[] getSum(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = arr.length-1; i>=0; i--) {
			if(arr[i] < 9) {
				arr[i]++;
				return arr;
			}
			arr[i] = 0;
		}
		int[] result = new int[arr.length + 1];
		result[0] = 1;
		return result;
	}
}
