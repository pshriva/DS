package ValidateSudokuSolution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		int[][] arr = {{4,3,5,2,6,9,7,8,1},
					   {6,8,2,5,7,1,4,9,3},
					   {1,9,7,8,3,4,5,6,2},
					   {8,2,6,1,9,5,3,4,7},
					   {3,7,4,6,8,2,9,1,5},
					   {9,5,1,7,4,3,6,2,8},
					   {5,1,9,3,2,6,8,7,4},
					   {2,4,8,9,5,7,1,3,6},
					   {7,6,3,4,1,8,2,5,9}};
		System.out.println(isValidSudoku(arr));
	}

	private static boolean isValidSudoku(int[][] arr) {
		return hasValidRows(arr) && hasValidColumns(arr) && hasValidBlocks(arr);
	}

	private static boolean hasValidColumns(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j<9; j++) {
				set.add(arr[j][i]);
			}
			if(set.size() != 9) {return false;}
		}
		return true;
	}

	private static boolean hasValidRows(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j<9; j++) {
				set.add(arr[i][j]);
			}
			if(set.size() != 9) {return false;}
		}
		return true;
	}
	
	private static boolean hasValidBlocks(int[][] arr) {
		for(int k = 0; k< 9; k++) {
			Set<Integer> set = new HashSet<>();
			for(int i = k/3*3; i<k/3*3+ 3; i++) {
				for(int j = k%3*3; j<k%3*3 + 3; j++) {
					set.add(arr[i][j]);
				}
			}
			if(set.size() != 9) {return false;}
		}
		return true;
	}
}
