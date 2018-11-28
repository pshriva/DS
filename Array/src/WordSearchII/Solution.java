package WordSearchII;
//LCA
import java.util.*;
public class Solution {
	public static void main(String[] args) {
//		char[][] board = {{'o','a','a','n'},
//						  {'e','t','a','e'},
//						  {'i','h','k','r'},
//						  {'i','f','l','v'}};
//		String[] words = {"eat","pea","rain","oath"};
		char[][] board = {{'a', 'b', 'c'},
						  {'a', 'e', 'd'},
						  {'a', 'f', 'g'}};
		String[] words = {"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
		List<String> result = findWords(board, words);
		System.out.println(result);
	}
// Simple DFS (No need to do again, just see the recursion function, remember to mark visit false, and all recursion in if condition)
//	private static List<String> findWords(char[][] board, String[] words) {
//		Set<String> result = new HashSet<>();
//		if(board == null || board.length == 0){return new ArrayList<>();}
//		for(int i = 0; i < board.length; i++){
//			for(int j = 0; j < board[0].length ; j++){
//				for(String word : words){
//					boolean[][] visited = new boolean[board.length][board[0].length];
//					if(!result.contains(word) && exists(board, i, j, word, 0, visited)){result.add(word);}
//				}
//			}
//		}
//		return new ArrayList<>(result);
//	}
//
//	private static boolean exists(char[][] board, int i, int j, String word, int index, boolean[][]visited) {
//		if(i < 0 || j < 0 || i >= board.length || j>= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){
//			return false;
//		}
//		visited[i][j] = true;
//		if(index == word.length()-1){return true;}
//		if(exists(board, i, j+1, word, index+1, visited)
//		   || exists(board, i, j-1, word, index+1, visited)
//		   || exists(board, i+1, j, word, index+1, visited)
//		   || exists(board, i-1, j, word, index+1, visited)){return true;}
//		visited[i][j] = false;
//		return false;
//	}


//	DFS plus Trie
	private static List<String> findWords(char[][] board, String[] words) {
		Trie t = createWords(words);
		List<String> result = new ArrayList<>();
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j< board[0].length; j++){
				findWord(board, i, j, result, t);
			}
		}
		return result;
	}
	
	private static void findWord(char[][] board, int i, int j, List<String> result, Trie t) {
		char c = board[i][j];
		if(c == '#' || t.child[c - 'a'] == null){return;}
		t = t.child[c - 'a'];
		if(t.word != null){
			result.add(t.word);
			t.word = null;
		}
		board[i][j] = '#';
		if(i > 0){findWord(board, i-1, j, result, t);}
		if(j > 0){findWord(board, i, j-1, result, t);}
		if(i < board.length - 1){findWord(board, i+1, j, result, t);}
		if(j < board[0].length - 1){findWord(board, i, j+1, result, t);}
		board[i][j] = c;
	}

	private static Trie createWords(String[] words) {
		Trie t = new Trie();
		for(String word : words){
			Trie root = t;
			for(char c : word.toCharArray()){
				if(root.child[c - 'a'] == null){
					root.child[c - 'a'] = new Trie();
				}
				root = root.child[c - 'a'];
			}
			root.word = word;
		}
		return t;
	}

}
