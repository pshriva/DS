package WordSearch;
//LCA
public class Solution {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		boolean wordExists = findWord(board, word);
		
		System.out.println(wordExists);
	}

//	private static boolean findWord(char[][] board, String word) {
//		boolean[][] visited = new boolean[board.length][board[0].length];
//		for(int i = 0; i<board.length; i++){
//			for(int j = 0; j<board[0].length; j++){
//				if(board[i][j] == word.charAt(0) && searchWord(board, i, j, visited, word, 0)){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	private static boolean searchWord(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
//		if(index == word.length()){return true;}
//		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){return false;}
//		visited[i][j] = true;
//		if(searchWord(board, i, j-1, visited, word, index+1)||
//				searchWord(board, i, j+1, visited, word, index+1)||
//				searchWord(board, i+1, j, visited, word, index+1)||
//				searchWord(board, i-1, j, visited, word, index+1)){
//			return true;
//		}
//		visited[i][j] = false;
//		return false;
//	}
	
	
//	Without using an extra space (except for recursion)
	private static boolean findWord(char[][] board, String word) {
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				if(board[i][j] == word.charAt(0) && searchWord(board, i, j, word, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean searchWord(char[][] board, int i, int j, String word, int index) {
		if(index == word.length()){return true;}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || board[i][j] == '-'){return false;}
		char curr = board[i][j];
		board[i][j] = '-';
		//or simply - board[i][j]^=5; //or any other number
		if(searchWord(board, i, j-1, word, index+1)||
				searchWord(board, i, j+1, word, index+1)||
				searchWord(board, i+1, j, word, index+1)||
				searchWord(board, i-1, j, word, index+1)){
			return true;
		}
		board[i][j] = curr;
//		board[i][j]^=5; // back again to restore the same number, so that we also do not use the O(k) space for each recursion, where k = word.length()
		return false;
	}

}
