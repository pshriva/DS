package PascalsTriangle2;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {

	public static void main(String[] args) {
		int n = 1;
		List<Integer> result = getRow(n);
		System.out.println(result);
	}

	private static List<Integer> getRow(int n) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i<=n; i++){
			result.add(0,1);
			for(int j = 1; j<result.size()-1; j++){
				result.set(j, result.get(j) + result.get(j+1));
			}
		}
		return result;
	}

}
