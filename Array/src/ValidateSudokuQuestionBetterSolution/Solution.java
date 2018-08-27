package ValidateSudokuQuestionBetterSolution;

public class Solution {

	public static void main(String[] args) {
		char[][] arr = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
//		System.out.println("Hi");
		System.out.println(isValidSudoku(arr));
	}

	private static boolean isValidSudoku(char[][] arr) {
		for(int i = 0; i< 9; i++) {
            boolean row[] = new boolean[10];
			boolean column[] = new boolean[10];
			boolean block[] = new boolean[10];
			for(int j = 0; j < 9 ; j++) {
				
				//row
				if(arr[i][j] != '.') {
					if(row[arr[i][j] - '0']) {return false;}
					row[arr[i][j] - '0'] = true;
				}
				//column
				if(arr[j][i] != '.') {
					if(column[arr[j][i] - '0']) {return false;}
					column[arr[j][i] - '0'] = true;
				}
				//block
				int rowIndex = i/3*3 + j/3;
				int colIndex = i%3*3 + j%3;
				if(arr[rowIndex][colIndex] != '.') {
					if(block[arr[rowIndex][colIndex] - '0']) {return false;}
					block[arr[rowIndex][colIndex] - '0'] = true;
				}
			}
			
		}
		return true;
	}

}
