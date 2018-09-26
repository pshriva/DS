package SingleNumber;

public class Solution {

	public static void main(String[] args) {
		int[]arr = {4,1,2,1,2};
		int singleElement = getSingleElement(arr);
		System.out.println(singleElement);
	}

	private static int getSingleElement(int[] arr) {
		int ans = 0;
		for(int i : arr){
			ans = ans ^ i;
		}
		return ans;
	}

}
