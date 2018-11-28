package ZigZagIterator;

import java.util.*;
//https://medium.com/@rebeccahezhang/leetcode-281-zigzag-iterator-a5ee60dd20ea
public class MyBestIterator {
	List<Iterator> list;
	public MyBestIterator(List<Integer> list1, List<Integer> list2){
		list = new ArrayList<>();
		if(list1 != null){list.add(list1.iterator());}
		if(list2 != null){list.add(list2.iterator());}
	}
	
	public int next(){
		Iterator it = list.remove(0);
		int element = (int)it.next();
		if(it.hasNext()){list.add(it);}
		return element;
	}
	
	public boolean hasNext(){
		return !list.isEmpty();
	}
}
