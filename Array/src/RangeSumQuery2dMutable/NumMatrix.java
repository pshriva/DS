package RangeSumQuery2dMutable;

public class NumMatrix {
	int[][] matrix;
	int[][] rowSumMatrix;
	
	public NumMatrix(int[][] matrix){
		if(matrix == null || matrix.length == 0){return;}
		this.matrix = matrix;
		rowSumMatrix = new int[matrix.length][matrix[0].length];
		for(int i = 0; i<matrix.length ; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(j == 0){rowSumMatrix[i][j] = matrix[i][j];}
				else{rowSumMatrix[i][j] = rowSumMatrix[i][j-1] + matrix[i][j];}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for(int i = row1 ; i<= row2; i++){
			if(col1 == 0){sum += rowSumMatrix[i][col2];}
			else{ sum += rowSumMatrix[i][col2] - rowSumMatrix[i][col1-1];}
		}
		return sum;
	}

	public void update(int row, int col, int value) {
		for(int i = col ; i < rowSumMatrix[0].length; i++){
			rowSumMatrix[row][i] = (rowSumMatrix[row][i] - matrix[row][col] + value);
		}
		matrix[row][col] = value;
	}
}
