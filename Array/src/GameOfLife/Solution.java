package GameOfLife;

public class Solution {
	public static void main(String[] args){
		int[][] lives = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
		};
		getNextLevelOfLives(lives);
		for(int i = 0; i<lives.length; i++){
			for(int j = 0; j< lives[0].length; j++){
				System.out.print(lives[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void getNextLevelOfLives(int[][] lives) {
		for(int i = 0; i< lives.length; i++){
			for(int j = 0; j< lives[0].length; j++){
				int livesAround = getNeighbourLives(lives, i, j);
				if(lives[i][j] == 1 && (livesAround == 2 || livesAround == 3)){
					lives[i][j] = 3;
				}else if(lives[i][j] == 0 && livesAround == 3){
					lives[i][j] = 2;
				}
			}
		}
		for(int i = 0; i<lives.length; i++){
			for(int j = 0; j< lives[0].length; j++){
				lives[i][j] = lives[i][j] >> 1;
			}
		}
	}

	private static int getNeighbourLives(int[][] lives, int x, int y) {
		int life = 0;
		for(int i = Math.max(x-1, 0); i<=Math.min(lives.length-1, x+1); i++){
			for(int j = Math.max(y-1, 0); j<=Math.min(y+1, lives[0].length-1); j++){
				life = life + (lives[i][j] & 1);
			}
		}
		life = life - (lives[x][y] & 1);
		return life;
	}
}
