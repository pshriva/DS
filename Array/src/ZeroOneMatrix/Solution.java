package ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;
//LCA   <graph BFS>
public class Solution {

	public static void main(String[] args) {
		int[][] matrix = {{0,0,1,0}, {0,0,1,0}, {0,1,1,1}, {1,1,1,1}};
		int[][] result = getZeroDistance(matrix);
//		for(int i = 0; i<result.length ; i++){
//			for(int j = 0; j < result[0].length ; j++){
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	private static int[][] getZeroDistance(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix[0].length];
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i<matrix.length ; i++){
			for(int j = 0; j < matrix[0].length ; j++){
				if(matrix[i][j] == 1){
					result[i][j] = Integer.MAX_VALUE;
				}else{
					queue.add(new int[]{i,j});
				}
			}
		}
		getZeroDistance(result, matrix, queue);
		return result;
	}

	private static void getZeroDistance(int[][] result, int[][] matrix, Queue<int[]> queue) {
		int[][] directions = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
		while(!queue.isEmpty()){
			int[] points = queue.poll();
			for(int[] dir : directions){
				int x = points[0] + dir[0];
				int y = points[1] + dir[1];
				if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length){
					int distance = matrix[x][y] == 0 ? 0 : result[points[0]][points[1]] + 1;
					if(distance < result[x][y]){
						result[x][y] = distance;
						queue.add(new int[]{x, y});
					}
				}
			}
		}
	}

}
