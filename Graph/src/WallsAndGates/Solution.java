package WallsAndGates;

import java.util.*;
//LL
public class Solution {

	public static void main(String[] args) {
		int INF = Integer.MAX_VALUE;
		int[][] grid = {{INF, -1, 0, INF},
						{INF, INF, INF, -1},
						{INF, -1, INF, -1},
						{0, -1, INF, INF}};
		getMinDistanceFromGate(grid);
		for(int[] row : grid){
			for(int val : row){
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
//	BFS, I find it better than DFS
	private static void getMinDistanceFromGate(int[][] grid) {
		int INF = Integer.MAX_VALUE;
		if(grid == null || grid.length == 0){return;}
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid[0].length ; j++){
				if(grid[i][j] == 0){
					queue.add(new int[]{i,j});
				}
			}
		}
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int val = grid[x][y];
			if(x > 0 && grid[x-1][y] == INF){
				grid[x-1][y] = val+1;
				queue.add(new int[]{x-1, y});
			}
			if(x < grid.length - 1 && grid[x+1][y] == INF){
				grid[x+1][y] = val+1;
				queue.add(new int[]{x+1, y});
			}
			if(y > 0 && grid[x][y-1] == INF){
				grid[x][y-1] = val+1;
				queue.add(new int[]{x, y-1});
			}
			if(y < grid[0].length-1 && grid[x][y+1] == INF){
				grid[x][y+1] = val+1;
				queue.add(new int[]{x, y+1});
			}
		}
	}
	
	
//	DFS
//	private static void getMinDistanceFromGate(int[][] grid) {
//		if(grid == null || grid.length == 0){return;}
//		for(int i = 0; i < grid.length; i++){
//			for(int j = 0; j < grid[0].length; j++){
//				if(grid[i][j] == 0){
//					boolean[][] visited = new boolean[grid.length][grid[0].length];
//					findMinDistance(grid, i, j, visited, 0);
//				}
//			}
//		}
//	}
//
//	private static void findMinDistance(int[][] grid, int i, int j, boolean[][] visited, int distance) {
//		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
//				 || visited[i][j] || grid[i][j] == -1){return;}
//		visited[i][j] = true;
//		grid[i][j] = Math.min(grid[i][j], distance);
//		findMinDistance(grid, i-1, j, visited, distance+1);
//		findMinDistance(grid, i+1, j, visited, distance+1);
//		findMinDistance(grid, i, j-1, visited, distance+1);
//		findMinDistance(grid, i, j+1, visited, distance+1);
//	}
	
//	DFS without using visited, hence no extra space other than recursive call
//	private static void getMinDistanceFromGate(int[][] grid) {
//		if(grid == null || grid.length == 0){return;}
//		for(int i = 0; i < grid.length; i++){
//			for(int j = 0; j < grid[0].length; j++){
//				if(grid[i][j] == 0){
//					findMinDistance(grid, i, j, 0);
//				}
//			}
//		}
//	}
//
//	private static void findMinDistance(int[][] grid, int i, int j, int distance) {
//		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < distance){return;}
//		grid[i][j] = Math.min(grid[i][j], distance);
//		findMinDistance(grid, i-1, j, distance+1);
//		findMinDistance(grid, i+1, j, distance+1);
//		findMinDistance(grid, i, j-1, distance+1);
//		findMinDistance(grid, i, j+1, distance+1);
//	}
}
