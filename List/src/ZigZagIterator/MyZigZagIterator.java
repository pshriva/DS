package ZigZagIterator;

import java.util.*;

public class MyZigZagIterator implements Iterator{
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turn;
	public MyZigZagIterator(List<Integer> list1, List<Integer> list2){
		it1 = list1.iterator();
		it2 = list2.iterator();
	}
	@Override
	public boolean hasNext() {
		return it1.hasNext() || it2.hasNext();
	}
	@Override
	public Object next() {
		if(!it1.hasNext() && !it2.hasNext()){throw new NoSuchElementException();}
		int element;
		if(turn++ % 2 == 0){
			if(it1.hasNext()){
				element = it1.next();
			}else{
				element = it2.next();
			}
		}else{
			if(it2.hasNext()){
				element = it2.next();
			}else{
				element = it1.next();
			}
		}
		return element;
	}
}
