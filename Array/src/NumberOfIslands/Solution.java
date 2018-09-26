package NumberOfIslands;


//LCA
public class Solution {
	public static void main(String[] args){
//		char[][] arr = {
//				{'1','1','1','1','0'},
//				{'1','1','0','1','0'},
//				{'1','1','0','0','0'},
//				{'0','0','0','1','0'}
//		};
		char[][] arr = {
				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'}
		};
		int numberOfIslands = getNumberOfIslands(arr);
		System.out.println(numberOfIslands);
	}

	private static int getNumberOfIslands(char[][] arr) {
		int count = 0;
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j< arr[0].length; j++){
				if(arr[i][j] == '1'){
					count++;
					markIsland(arr, i, j);
				}
			}
		}
		return count;
	}

	private static void markIsland(char[][] arr, int i, int j) {
		if(i >= arr.length || i < 0 || j<0 || j >= arr[0].length || arr[i][j] == '0'){return;}
		arr[i][j] = '0';
		markIsland(arr, i, j+1);
		markIsland(arr, i+1, j);
		markIsland(arr, i-1, j);
		markIsland(arr, i, j-1);
	}
}
