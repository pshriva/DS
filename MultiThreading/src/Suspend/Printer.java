package Suspend;

public class Printer {
	public synchronized void print(){
		System.out.println(Thread.currentThread().getName() + " wants to print");
		if(Thread.currentThread().getName().equals("PrimaryThread")){
			System.out.println("Suspending");
			Thread.currentThread().suspend();
			System.out.println("Threaad resumed");
		}
		System.out.println("Finished printing");
	}
}
