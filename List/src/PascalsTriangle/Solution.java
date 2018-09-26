package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {

	public static void main(String[] args) {
		int n = 3;
		List<List<Integer>> triangle = generateTriangle(n);
		System.out.println(triangle);
	}

	private static List<List<Integer>> generateTriangle(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		for(int i = 0; i<n; i++){
			current.add(0,1);
			for(int j = 1; j<current.size()-1; j++){
				System.out.println("Hi");
				current.set(j, current.get(j) + current.get(j+1));
			}
			result.add(new ArrayList<>(current));
		}
		return result;
	}

//	private static List<List<Integer>> generateTriangle(int n) {
//		List<List<Integer>> result = new ArrayList<>();
//		if(n == 0){return result;}
//		List<Integer> current = new ArrayList<>();
//		current.add(1);
//		result.add(current);
//		for(int i = 1; i<n; i++){
//			List<Integer> temp = new ArrayList<>();
//			temp.add(current.get(0));
//			int prev = current.get(0);
//			for(int j = 1; j<current.size(); j++){
//				int curr = current.get(j);
//				temp.add(prev + curr);
//				prev = curr;
//			}
//			temp.add(current.get(current.size()-1));
//			current = temp;
//			result.add(temp);
//		}
//		return result;
//	}

}
