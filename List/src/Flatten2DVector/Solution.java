package Flatten2DVector;

import java.util.*;

public class Solution {
// A sublist might not have null elements, either it has elements or it is all empty, 
//	so, right solution is in class Vector2D
	public static void main(String[] args) {
//		List<List<Integer>> list = new ArrayList<>(Arrays.asList(Arrays.asList(1,2),
//												   Arrays.asList(3),
//												   Arrays.asList(4,5,6)));

		
		
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(null, null, null, null)));
		list.add(new ArrayList<>(Arrays.asList(1, 2, null, 2, null, 3, null)));
		list.add(new ArrayList<>(Arrays.asList(3,3,3)));
		list.add(new ArrayList<>(Arrays.asList(null, null)));
		list.add(null);
		list.add(new ArrayList<>(Arrays.asList(3,3,3,4)));
//		MyIterator it = new MyIterator(list);
//		
//		while(it.hasNext()){
//			System.out.print(it.next() + " ");
//		}
		
		
	}

}
