package RangeSumQuery2dMutable;

public class NumMatrix2 {
	int[][] tree;
	int[][] nums;
	int m;
	int n;
	
	public NumMatrix2(int[][] matrix){
		m = matrix.length;
		n = matrix[0].length;
		tree = new int[m+1][n+1];
		nums = new int[m][n];
		if(matrix == null || m == 0){return;}
		for(int i = 0; i < m; i++){
			for(int j = 0; j< n ; j++){
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {
		if(m == 0 || n == 0){return;}
		int increasedBy = val - nums[row][col];
		nums[row][col] = val;
		for(int i = row+1; i<tree.length; i+=i&(-i)){
			for(int j = col+1; j < tree[0].length; j+=j&(-j)){
				tree[i][j] += increasedBy;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(m == 0 || n == 0){return 0;}
		return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
	}

	private int sum(int row, int col) {
		int sum = 0;
		for(int i = row ; i>0 ; i-=i&(-i)){
			for(int j = col; j>0; j-=j&(-j)){
				sum += tree[i][j];
			}
		}
		return sum;
	}
}
