package Mcknsy;

import java.util.*;

// dig number of locations to find path between 2 lakes
public class Solution {
	public static void main(String args[]) {
		List<List<Integer>> area_map = new ArrayList<>();
		// area_map.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		// area_map.add(new ArrayList<>(Arrays.asList(0,0,1,1,0,1)));
		// area_map.add(new ArrayList<>(Arrays.asList(0,0,1,1,0,1)));
		// area_map.add(new ArrayList<>(Arrays.asList(0,1,1,1,1,1)));
		// area_map.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		area_map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1, 1, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0, 1, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0, 0, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0, 0, 1)));
		area_map.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0, 1, 1)));
		int result = digCanal(area_map);
		System.out.println("Result " + result);
	}

	private static int digCanal(List<List<Integer>> area_map) {
		int[][] arr = new int[area_map.size()][area_map.get(0).size()];
		int[][] visited = new int[area_map.size()][area_map.get(0).size()];
		int i = 0;
		int j = 0;
		int result = Integer.MAX_VALUE;
		boolean lakeFound = false;
		Set<List<Integer>> startingPoints = new HashSet<>();
		for (List<Integer> row : area_map) {
			for (int val : row) {
				arr[i][j++] = val;
			}
			j = 0;
			i++;
		}
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					getStartingCoordinates(arr, i, j, startingPoints, visited);
					lakeFound = true;
					break;
				}
			}
			if (lakeFound == true) {
				break;
			}
		}
		for (List<Integer> coordinates : startingPoints) {
			System.out.println(coordinates.get(0) + " " + coordinates.get(1));
			int x = coordinates.get(0);
			int y = coordinates.get(1);
			int count = getMinimumDigCount(arr, x, y, 0);
			result = Math.min(result, count);
		}
		return result;
	}

	private static void getStartingCoordinates(int[][] arr, int i, int j, Set<List<Integer>> startingPoints,
			int[][] visited) {
		if (i >= arr.length || i < 0 || j >= arr[0].length || j < 0 || visited[i][j] == 1) {
			return;
		}
		if (arr[i][j] == 1) {
			startingPoints.add(new ArrayList<>(Arrays.asList(i, j)));
			return;
		}
		visited[i][j] = 1;
		arr[i][j] = 1;
		getStartingCoordinates(arr, i, j - 1, startingPoints, visited);
		getStartingCoordinates(arr, i, j + 1, startingPoints, visited);
		getStartingCoordinates(arr, i + 1, j, startingPoints, visited);
		getStartingCoordinates(arr, i - 1, j, startingPoints, visited);
	}

	private static int getMinimumDigCount(int[][] arr, int i, int j, int count) {
		if (i >= arr.length || j >= arr[0].length) {
			return Integer.MAX_VALUE;
		}
		if (arr[i][j] == 0) {
			return count;
		}
		return Math.min(getMinimumDigCount(arr, i + 1, j, count + 1), getMinimumDigCount(arr, i, j + 1, count + 1));
	}
}
