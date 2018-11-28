package ReentrantLockAndThreadPool;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{
	ReentrantLock rl;
	String name;
	public Worker(ReentrantLock rl, String name){
		this.rl = rl;
		this.name = name;
	}
	
	public Worker(ReentrantLock rl){
		this.rl = rl;
	}
//	use this method when using ThreadPool in Solution class
//	@Override
//	public void run() {
//		rl.lock();
//		System.out.println("Running by " + this.name);
//		rl.unlock();
//	}
	@Override
	public void run() {
		rl.lock();
		System.out.println("Running by " + Thread.currentThread().getName());
		rl.unlock();
	}

}
