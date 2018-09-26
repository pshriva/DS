package SetMatrixZeroes;
//LCA
public class Solution {
	public static void main(String args[]){
		int[][] arr = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
		setZeroElementRowColumnsToZero(arr);
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
//it is still O[m+n] in space complexity, it could be made an O(1) in space complexity, 
//	if instead of using another row or column array to mark the zeroes, we keep the marker in the 1st row and 1st column itself, 
//	This is done in the method after this method
//	private static void setZeroElementRowColumnsToZero(int[][] arr) {
//		boolean[] r = new boolean[arr.length];
//		boolean[] c = new boolean[arr[0].length];
//		for(int i = 0; i<arr.length; i++){
//			for(int j = 1; j<arr[0].length; j++){
//				if(arr[i][j] == 0){
//					r[i] = true;
//					c[j] = true;
//				}
//			}
//		}
//		for(int i = 0; i<arr.length; i++){
//			for(int j = 0; j<arr[0].length; j++){
//				if(r[i] == true || c[j] == true){
//					arr[i][j] = 0;
//				}
//			}
//		}
//	}
	
//LCA	
//	If the element is zero, then mark its 1st row element and its 1st column element as zero and then in the 2nd loop,
//	going bottom up, see if the 1st element in the current row or column is zero, then make that element zero
	private static void setZeroElementRowColumnsToZero(int[][] arr) {
		int zeroCol = -1;
		for(int i = 0; i<arr.length; i++){
			if(arr[i][0] == 0){zeroCol = 0;}
			for(int  j = 1; j  <arr[0].length; j++){
				if(arr[i][j] == 0){arr[i][0] = arr[0][j] = 0;}
			}
		}
		
		for(int i = arr.length - 1 ; i>= 0; i--){
//			Last value to consider for j is 1 not 0 bcz, for 1st column, we already are maintaining a variable zeroCol
			for(int j = arr[0].length - 1 ; j>= 1; j--){
				if(arr[i][0] == 0 || arr[0][j] == 0){arr[i][j] = 0;}
			}
			if(zeroCol == 0){
				arr[i][0] = 0;
			}
		}
	}
	
}
