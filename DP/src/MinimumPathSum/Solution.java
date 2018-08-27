package MinimumPathSum;
//LCA
public class Solution {
	public static void main(String args[]) {
		
		int[][] grid = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},
						{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},
						{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},
						{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},
						{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},
						{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},
						{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},
						{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},
						{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},
						{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},
						{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},
						{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},
						{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},
						{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},
						{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},
						{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},
						{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},
						{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
//		int[][] grid = {{1,3,1},
//				  {1,5,1},
//				  {4,2,1}};
		int minimumPathSum = getMinimumPathSum(grid);
		System.out.println(minimumPathSum);
	}

	private static int getMinimumPathSum(int[][] grid) {
		int[][] minsum = new int[grid.length][grid[0].length];
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j <grid[0].length; j++) {
				if(i ==0 && j ==0) {minsum[i][j] = grid[i][j];}
				else if(i == 0) {minsum[i][j] = minsum[i][j-1] + grid[i][j];}
				else if(j == 0) {minsum[i][j] = minsum[i-1][j] + grid[i][j];}
				else {minsum[i][j] = grid[i][j] + Math.min(minsum[i-1][j], minsum[i][j-1]);}
			}
		}
		return minsum[grid.length - 1][grid[0].length - 1];
	}
	//Recursive, time limit might exceed, just takes way too much time
//	private static int getMinimumPathSum(int[][] grid) {
//		return minPath(grid, 0,0);
//	}
//
//	private static int minPath(int[][] grid, int i, int j) {
//		if(i == grid.length - 1 && j == grid[0].length - 1) {return grid[i][j];}
//		else if(j == grid[0].length-1) {
//			return grid[i][j] + minPath(grid, i+1, j);
//		}else if(i == grid.length - 1) {
//			return grid[i][j] + minPath(grid, i, j+1);
//		}
//		return grid[i][j] + Math.min(minPath(grid, i, j+1), minPath(grid, i+1, j));
//	}
}
