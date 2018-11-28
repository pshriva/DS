package ZigZagIterator;

import java.util.*;
// LL
public class Solution {
	public static void main(String[] args){
		
//		Without using actual Iterator in the ZigZagIterator class
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,7,8,9,0));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6));
		ZigZagIterator it = new ZigZagIterator(list1, list2);
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		
//		With using actual Iterator in the MysZigZagIterator class
		List<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,7,8,9,0));
		List<Integer> list4 = new ArrayList<>(Arrays.asList(3,4,5,6));
		MyZigZagIterator it1 = new MyZigZagIterator(list3, list4);
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
//		Best approach
		List<Integer> list5 = new ArrayList<>(Arrays.asList(1,2,7,8,9,0));
		List<Integer> list6 = new ArrayList<>(Arrays.asList(3,4,5,6));
		MyBestIterator it2 = new MyBestIterator(list3, list4);
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
	}
}
