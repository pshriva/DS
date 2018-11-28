package Collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * Now we do not get any exception, so, the o/p is either - 1,2,3 or o/p - 1,2,3,7
 */
public class SolutionConcurrent extends Thread{
	static List<Integer> list = new CopyOnWriteArrayList();
	
	public void run(){
		list.add(7);
	}
	public static void main(String[] args) {
		list.add(1);
		list.add(2);
		list.add(3);
		SolutionConcurrent sc = new SolutionConcurrent();
		sc.start();
		Iterator it = list.iterator();
		while(it.hasNext()){System.out.println(it.next());}
	}

}
