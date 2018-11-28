package GrayCode;

import java.util.*;
//LCA
public class Solution {
	public static void main(String args[]){
		int n = 2;
		List<Integer> graySeries = getGraySeries(n);
		System.out.println(graySeries);
	}

	private static List<Integer> getGraySeries(int n) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i< (1 << n); i++){
			result.add(i^i>>1);
		}
		return result;
	}
}
