package LongestIncreasingPathInAMatrix;
//LCA
public class Solution {

	public static void main(String[] args) {
//		important use case to mark visited[i][j] false, (in time limited exceeded solution)
		int[][] matrix = {{5, 4, 9},
						  {7, 3, 9},
						  {8, 9, 9}};
//		int[][] matrix = {{9, 9, 4},
//						  {6, 6, 8},
//						  {2, 1, 1}};
//		int[][] matrix = {{0},
//						  {1},
//						  {5},
//						  {5}};
		int longestPath = getLongestIncreasingPath(matrix);
		System.out.println(longestPath);
	}

	
//	Bottom up - Backtracking + memorization
	private static int getLongestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0){return 0;}
		int maxLength = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				maxLength = Math.max(maxLength, getMaxLen(i, j, matrix, dp, matrix[i][j]-1));
			}
		}
		return maxLength;
	}

	private static int getMaxLen(int i, int j, int[][] matrix, int[][] dp, int prev) {
		if(i < 0 || j< 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev){
			return 0;
		}
		if(dp[i][j] > 0){
			return dp[i][j];
		}
		
		int left = getMaxLen(i, j-1, matrix, dp, matrix[i][j]) + 1;
		int top = getMaxLen(i-1, j, matrix, dp, matrix[i][j]) + 1;
		int right = getMaxLen(i, j+1, matrix, dp, matrix[i][j]) + 1;
		int down = getMaxLen(i+1, j, matrix, dp, matrix[i][j]) + 1;
		dp[i][j] = Math.max(left, Math.max(top, Math.max(right, down)));
		return dp[i][j];
	}

	
//	Time limited exceeded
//	private static int getLongestIncreasingPath(int[][] matrix) {
//		if(matrix == null || matrix.length == 0){return 0;}
//		int[] len = new int[1];
//		for(int i = 0; i< matrix.length ; i++){
//			for(int j = 0; j< matrix[0].length; j++){
//				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//				getLengthofPath(matrix, i, j, matrix[i][j]-1, len, 0, visited);
//			}
//		}
//		return len[0];
//	}
//
//	private static void getLengthofPath(int[][] matrix, int i, int j, int prev, int[] len, int curr, boolean[][] visited) {
//		if(i < 0 || j <  0 || i>= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j]- prev <= 0){
//			return;
//		}
//		visited[i][j] = true;
//		curr++;
//		len[0] = Math.max(len[0], curr);
//		getLengthofPath(matrix, i, j+1, matrix[i][j], len, curr, visited);
//		getLengthofPath(matrix, i+1, j, matrix[i][j], len, curr, visited);
//		getLengthofPath(matrix, i, j-1, matrix[i][j], len, curr, visited);
//		getLengthofPath(matrix, i-1, j, matrix[i][j], len, curr, visited);
//		visited[i][j] = false;
//	}

}
