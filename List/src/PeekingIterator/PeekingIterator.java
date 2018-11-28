package PeekingIterator;

import java.util.*;
// LCA
public class PeekingIterator implements Iterator<Integer>{
	Iterator<Integer> iter;
	Integer next;
	boolean noSuchElement;
	
	public PeekingIterator(Iterator<Integer> iterator){
		iter = iterator;
		getNextInAdvance();
	}
	
	public Integer peek(){
		return next;
	}
	
	public Integer next(){
		if(noSuchElement){throw new NoSuchElementException();}
		Integer element = next;
		getNextInAdvance();
		return element;
	}
	

	
	public boolean hasNext(){
		return !noSuchElement;
	}
	private void getNextInAdvance() {
		if(iter.hasNext()){
			next = iter.next();
		}else{
			noSuchElement = true;
		}
	}
	

}

//public class PeekingIterator<T> implements Iterator{
//	Iterator<T> iter;
//	T next;
//	boolean noSuchElement;
//	
//	public PeekingIterator(Iterator<T> iterator){
//		iter = iterator;
//		getNextInAdvance();
//	}
//	
//	public T peek(){
//		return next;
//	}
//	
//	public T next(){
//		if(noSuchElement){throw new NoSuchElementException();}
//		T element = next;
//		getNextInAdvance();
//		return element;
//	}
//	
//
//	
//	public boolean hasNext(){
//		return !noSuchElement;
//	}
//	private void getNextInAdvance() {
//		if(iter.hasNext()){
//			next = iter.next();
//		}else{
//			noSuchElement = true;
//		}
//	}
//	
//
//}
