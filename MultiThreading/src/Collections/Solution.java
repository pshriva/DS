package Collections;

import java.util.*;
/*
 *  One thread is adding 7 to the list, and other thread (main) is reading elements of list, so 3 outputs are possible:
 *  1. s runs, then main runs, so o/p - 1,2,3,7
 *  2. main runs, then s runs, so, o/p - 1,2,3
 *  3. while main iterates, the s also runs, o/p - ConcurrentModificationException
 */

public class Solution extends Thread{
	static List<Integer> list = new ArrayList<>();
	
	public void run(){
		list.add(7);
	}
	public static void main(String []args){
		list.add(1);
		list.add(2);
		list.add(3);
		Solution s = new Solution();
		s.start();
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
