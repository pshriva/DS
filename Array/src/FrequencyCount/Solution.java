package FrequencyCount;


//Provided that for an array of size n, the elements are in the range of (0 to n-1).
public class Solution {

	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 2, 3};
		System.out.println("Frequency Count is");
		getFrequencyCount(arr);
		for(int i = 0; i<arr.length; i++) {
			System.out.println(i+1 + " : " + arr[i]);
		}
	}

	private static void getFrequencyCount(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<arr.length; i++) {arr[i] = arr[i]-1;}
		for(int i = 0; i<arr.length; i++) {arr[arr[i]%n] = arr[arr[i]%n] + n;}
		for(int i = 0; i<arr.length; i++) {arr[i] = arr[i]/n;}
	}

}
