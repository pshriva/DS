package UniquePathsFromTopLeftToBottomRight;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String []args){
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		List<String> result = getAllPaths(arr);
		System.out.println(result);
	}

	private static List<String> getAllPaths(int[][] arr) {
		List<String> result = new ArrayList<>();
		getAllPaths(arr, result, 0, 0, "");
		return result;
	}

	private static void getAllPaths(int[][] arr, List<String> result, int i, int j, String sb) {
		if(i == arr.length - 1 && j == arr[0].length - 1){
			sb = sb + " " + arr[i][j];
			result.add(sb);
			return;
		}
		if(i>= arr.length || i< 0 || j>=arr[0].length || j < 0){
			return;
		}
		sb = sb + " " + arr[i][j];
		getAllPaths(arr, result, i, j+1, sb);
		getAllPaths(arr, result, i+1, j, sb);
	}
}
