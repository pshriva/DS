package ZigZagIterator;

import java.util.*;
// Without using iterator
public class ZigZagIterator {
	List<Integer> list1;
	List<Integer> list2;
	int turn;
	int pointer1;
	int pointer2;
	
	public ZigZagIterator(List<Integer> list1, List<Integer> list2){
		this.list1 = list1;
		this.list2 = list2;
	}

	public boolean hasNext() {
		return pointer1 < list1.size() || pointer2 < list2.size();
	}

	public int next() {
		if(pointer1 >= list1.size() && pointer2 >= list2.size()){
			throw new NoSuchElementException();
		}
		int element;
		if(turn++ % 2 == 0){
			if(pointer1 < list1.size()){
				element = list1.get(pointer1++);
			}
			else{
				element = list2.get(pointer2++);
			}
			
		}else{
			if(pointer2 < list2.size()){
				element = list2.get(pointer2++);
			}
			else{
				element = list1.get(pointer1++);
			}
		}
		return element;
	}
	
	
}
