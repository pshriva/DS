package ValidateSudokuQuestion;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		char[][] arr = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(arr));
	}

	private static boolean isValidSudoku(char[][] arr) {
		return hasValidRows(arr) && hasValidColumns(arr) && hasValidBlocks(arr);
	}

	private static boolean hasValidRows(char[][] arr) {
		for(int i = 0; i < 9; i++) {
			boolean[] truth = new boolean[9];
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] == '.') {continue;}
				//char to int -> -'0'
				if(truth[(arr[i][j] - '0' - 1)]) {return false;}
				else {truth[(arr[i][j] - '0' - 1)] = true;}
			}
		}
		return true;
	}
	
	private static boolean hasValidColumns(char[][] arr) {
		for(int i = 0; i < 9; i++) {
			boolean[] truth = new boolean[9];
			for(int j = 0; j < 9; j++) {
				if(arr[j][i] == '.') {continue;}
				//char to int -> -'0'
				if(truth[(arr[j][i] - '0' - 1)]) {return false;}
				else {truth[(arr[j][i] - '0' - 1)] = true;}
			}
		}
		return true;
	}
	
	private static boolean hasValidBlocks(char[][] arr) {
		for(int i = 0; i < 9; i++) {
			boolean[] truth = new boolean[9];
			for(int j = i/3*3; j< i/3*3 + 3; j++) {
				for(int k = i%3*3; k < i%3*3+3; k++) {
					if(arr[j][k] == '.') {continue;}
					if(truth[(arr[j][k] - '0' - 1)]) {return false;}
					else {truth[(arr[j][k] - '0' - 1)] = true;}
				}
			}
		}
		return true;
	}
}
