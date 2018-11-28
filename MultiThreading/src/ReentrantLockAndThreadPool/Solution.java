package ReentrantLockAndThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
//	public static void main(String args[]){
//		ExecutorService pool = Executors.newFixedThreadPool(1);
//		ReentrantLock rl = new ReentrantLock();
//		Worker w1 = new Worker(rl, "Job1");
//		Worker w2 = new Worker(rl, "Job2");
//		Worker w3 = new Worker(rl, "Job3");
//		pool.execute(w1);
//		pool.execute(w2);
//		pool.execute(w3);
//	}
	public static void main(String args[]){
		ReentrantLock rl = new ReentrantLock();
		Worker w1 = new Worker(rl);
		Thread t1 = new Thread(w1, "One");
		Thread t2 = new Thread(w1, "Two");
		t1.start();
		t2.start();
	}
}
