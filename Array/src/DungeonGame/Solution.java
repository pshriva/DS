package DungeonGame;

import java.util.Arrays;
//LCA
public class Solution {

	public static void main(String[] args) {
//		int[][] board = {{0,0,0}, {1,1,-1}};
		int[][] board = {{100}};
		int initialEnergy = getMinimumInitialEnerygy(board);
		System.out.println(initialEnergy);
	}
////This is a recursive approach and just takes a lot of time.
//	private static int getMinimumInitialEnerygy(int[][] board) {
//		int energy = 1;
//		int[][] energyLevels = new int[board.length][board[0].length];
////		set all the distances to maximum
//		for(int[] a : energyLevels){Arrays.fill(a, Integer.MAX_VALUE);}
//		getMinimumEnergy(board, energyLevels, energy, board.length - 1, board[0].length - 1);
//		return energyLevels[0][0];
//	}
	
	

//	private static void getMinimumEnergy(int[][] board, int[][] energyLevels, int energy, int i, int j) {
//		if(i < 0 || j< 0){return;}
////		since the board[i][j] is already negative, so we are basically adding that amount of energy
//		else if(board[i][j] < 0){
//			energy = energy - board[i][j];
//		}else if(board[i][j] > 0){
////			If the board is powering up less, then we can be on this board with (energy - board[i][j]) energy
////			It is powering up more than we need for next block, we can come here with minimum energy
//			energy = board[i][j] < energy ? (energy - board[i][j])  : 1;
//		}
//		energyLevels[i][j] = Math.min(energyLevels[i][j], energy);
//		energy = energyLevels[i][j];
//		getMinimumEnergy(board, energyLevels, energy, i-1, j);
//		getMinimumEnergy(board, energyLevels, energy, i, j-1);
//	}
	
	
//	Same logic, iterative method
	
	private static int getMinimumInitialEnerygy(int[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0){return 1;}
		int m = board.length;
		int n = board[0].length;
		int[][] energyLevels = new int[m][n];
		energyLevels[m-1][n-1] = board[m-1][n-1] <= 0 ? 1 - board[m-1][n-1] : 1;
		for(int i = m-2 ; i>=0; i--){
			energyLevels[i][n-1] = energyLevels[i+1][n-1] - board[i][n-1] > 0 ? energyLevels[i+1][n-1] - board[i][n-1] : 1;
		}
		for(int i = n-2; i >= 0; i--){
			energyLevels[m-1][i] = energyLevels[m-1][i+1] - board[m-1][i] > 0 ? energyLevels[m-1][i+1] - board[m-1][i] : 1;
		}
		for(int i = m-2; i>=0;i--){
			for(int j = n-2; j>=0; j--){
				int energy = Math.min(energyLevels[i+1][j], energyLevels[i][j+1]);
				energyLevels[i][j] = energy - board[i][j] > 0 ? energy - board[i][j] : 1;
			}
		}
		return energyLevels[0][0];
	}
}
