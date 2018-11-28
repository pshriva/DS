package PeekingIterator;

import java.util.*;
// LCA
public class Solution {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,null, 3));
		Iterator<Integer> it = list.iterator();
		PeekingIterator pt = new PeekingIterator(it);
//		while(pt.hasNext()){System.out.println(pt.next());}
		System.out.println(pt.next() + " " + pt.peek() + " " + pt.next() + " "+ pt.next +" " + pt.hasNext());
		System.out.println();
	}

}
