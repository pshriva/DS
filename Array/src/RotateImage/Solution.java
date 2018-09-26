package RotateImage;
//LCA OS 100%
public class Solution {
	public static void main(String args[]){
		int[][] arr = {{5,1,9,11}, {2,4,8,10},{13,3,6,7}, {15,14,12,16}};
		rotateArray(arr);
		for(int i = 0; i< arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	/*
	 * arr[k][i] = 1st element of 1st row
	 * arr[i][n] = 1st element of last column
	 * arr[l][n-j] = last element of last row
	 * arr[l-j][m] = last element of 1st column
	 * reset j to 0 after every for loop
	 * basically all the element to be changed in clockwise direction
	 */
	private static void rotateArray(int[][] arr) {
		int k = 0;
		int l = arr.length-1;
		int m = 0;
		int n = arr[0].length-1;
		while(k < l && m < n){
			int j = 0;
			for(int i = k ; i<n; i++){
				int temp = arr[k][i];
				arr[k][i] = arr[l-j][m];
				arr[l-j][m] = arr[l][n-j];
				arr[l][n-j] = arr[i][n];
				arr[i][n] = temp;
				j++;
			}
			k++;
			n--;
			l--;
			m++;
		}
		
	}
}
