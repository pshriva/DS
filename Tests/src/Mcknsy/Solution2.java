package Mcknsy;

import java.util.*;

public class Solution2 {

	public static void main(String[] args) {
		List<List<Integer>> inputArray = new ArrayList<>();
		inputArray.add(new ArrayList<>(Arrays.asList(2,13)));
		inputArray.add(new ArrayList<>(Arrays.asList(5,3)));
		inputArray.add(new ArrayList<>(Arrays.asList(10,8)));
		inputArray.add(new ArrayList<>(Arrays.asList(13,4)));
		inputArray.add(new ArrayList<>(Arrays.asList(15,0)));
		inputArray.add(new ArrayList<>(Arrays.asList(17,10)));
		inputArray.add(new ArrayList<>(Arrays.asList(20,5)));
		inputArray.add(new ArrayList<>(Arrays.asList(25,9)));
		inputArray.add(new ArrayList<>(Arrays.asList(28,7)));
		inputArray.add(new ArrayList<>(Arrays.asList(31,0)));
		int area = getPondArea(inputArray);
	}

	private static int getPondArea(List<List<Integer>> inputArray) {
		List<List<Integer>> coordinates = new ArrayList<>();
		int end = coordinates.get(0).get(1);
		for(List<Integer> list : inputArray){
			
		}
		return 0;
	}

}
