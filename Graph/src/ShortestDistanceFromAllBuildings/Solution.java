package ShortestDistanceFromAllBuildings;

import java.util.*;
// LL
public class Solution {

	public static void main(String[] args) {
//		int[][] grid = new int[][]{{1,0,2,0,1},
//								   {0,0,0,0,0},
//								   {0,0,1,0,0}};
		int[][] grid = new int[][]{{0,0,0,0},
								   {0,1,0,0},
								   {0,0,1,0},
								   {0,2,0,1}};
		int minDistance = getMinDistance(grid);
		System.out.println(minDistance);
	}
	
	
// DFS can be done for the same question using recusion instead of queue	
//	BFS without distance array, decreasing grid[x][y] after every bfs and then decreasing the 'val' makes sure that the answer is the one that is reachable from every house('1')
	private static int getMinDistance(int[][] grid) {
		if(grid == null || grid.length == 0){return Integer.MIN_VALUE;}
		int[][] sum = new int[grid.length][grid[0].length];
		int[][] sides = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		int val = 0;
		int res = Integer.MAX_VALUE;
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[]{i, j});
					res = Integer.MAX_VALUE;
					int distance = 1;
					while(!queue.isEmpty()){
						int size = queue.size();
						for(int l = 0; l < size; l++){
							int a = queue.peek()[0];
							int b = queue.peek()[1];
							queue.poll();
							for(int k = 0; k<4; k++){
								int x = a + sides[k][0];
								int y = b + sides[k][1];
								if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == val){
									grid[x][y]--;
									queue.add(new int[]{x, y});
									sum[x][y] += distance;
									res = Math.min(res, sum[x][y]);
								}
							}
						}
						distance++;
					}
					val--;
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}


//	BFS
//	private static int getMinDistance(int[][] grid) {
//		if(grid == null || grid.length == 0){return Integer.MIN_VALUE;}
//		int[][] sum = new int[grid.length][grid[0].length];
//		int[][] sides = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
//		int val = 0;
//		int res = Integer.MAX_VALUE;
//		for(int i = 0; i<grid.length; i++){
//			for(int j = 0; j < grid[0].length; j++){
//				if(grid[i][j] == 1){
//					Queue<int[]> queue = new LinkedList<>();
//					queue.add(new int[]{i, j});
//					int[][] distance = new int[grid.length][grid[0].length];
//					res = Integer.MAX_VALUE;
//					while(!queue.isEmpty()){
//						int a = queue.peek()[0];
//						int b = queue.peek()[1];
//						queue.poll();
//						for(int k = 0; k<4; k++){
//							int x = a + sides[k][0];
//							int y = b + sides[k][1];
//							if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == val){
//								grid[x][y]--;
//								queue.add(new int[]{x, y});
//								distance[x][y] = distance[a][b] + 1;
//								sum[x][y] += distance[x][y];
//								res = Math.min(res, sum[x][y]);
//							}
//						}
//					}
//					val--;
//				}
//			}
//		}
//		return res == Integer.MAX_VALUE ? -1 : res;
//	}

	
//	BFS with debugging statements
//	private static int getMinDistance(int[][] grid) {
//		if(grid == null || grid.length == 0){return Integer.MIN_VALUE;}
//		int[][] sum = new int[grid.length][grid[0].length];
//		int[][] sides = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
//		int val = 0;
//		int res = Integer.MAX_VALUE;
//		for(int i = 0; i<grid.length; i++){
//			for(int j = 0; j < grid[0].length; j++){
//				if(grid[i][j] == 1){
//					System.out.println("*****");
//					Queue<int[]> queue = new LinkedList<>();
//					queue.add(new int[]{i, j});
//					int[][] distance = new int[grid.length][grid[0].length];
//					System.out.println("	Inside loop");
//					res = Integer.MAX_VALUE;
//					while(!queue.isEmpty()){
//						int a = queue.peek()[0];
//						int b = queue.peek()[1];
//						queue.poll();
//						System.out.println("		Popping " + a + " " + b);
//						for(int k = 0; k<4; k++){
//							int x = a + sides[k][0];
//							int y = b + sides[k][1];
//							if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == val){
//								System.out.println("			Valid point " + x + " " + y);
//								grid[x][y]--;
//								queue.add(new int[]{x, y});
//								distance[x][y] = distance[a][b] + 1;
//								sum[x][y] += distance[x][y];
//								System.out.println("Sum"+x+","+y +" is " + sum[x][y] +" res is "+res);
//								
//								res = Math.min(res, sum[x][y]);
//								System.out.println("New res " + res);
//							}
//						}
//					}
//					System.out.println("Distance array");
//					for(int[] m : distance){
//						for(int n : m){
//							System.out.print(n + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("Sum array");
//					for(int[] m : sum){
//						for(int n : m){
//							System.out.print(n + " ");
//						}
//						System.out.println();
//					}
//					System.out.println("res " + res);
//					
//					val--;
//				}
//			}
//		}
//		return res == Integer.MAX_VALUE ? -1 : res;
//	}

	


}
