package SearchA2DMatrix;
//LCA
public class Solution {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int target = 3;
		boolean hasTarget = containsTarget(matrix, target);
		System.out.println(hasTarget);
	}

	private static boolean containsTarget(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)return false;
		int i = 0;
		int j = matrix[0].length-1;
		while(i<matrix.length && j >= 0){
			if(matrix[i][j] == target){return true;}
			if(target < matrix[i][j]){
				j--;
			}else{
				i++;
			}
		}
		return false;
	}

}
