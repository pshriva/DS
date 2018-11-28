package Runnable;

public class Solution {
	public static void main(String []args){
		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r, "RunnableThread");
		t1.start();
		System.out.println(Thread.currentThread().getName() + " is executing");
	}
}
