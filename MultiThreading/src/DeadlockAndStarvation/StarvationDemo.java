package DeadlockAndStarvation;

public class StarvationDemo extends Thread{
	public StarvationDemo(String name){
		super(name);
	}
	public void run(){
		System.out.println(Thread.currentThread().getName() + " is running ");
	}
	public static void main(String[] args) {
		StarvationDemo t1 = new StarvationDemo("One");
		t1.setPriority(10);
		StarvationDemo t2 = new StarvationDemo("Two");
		t2.setPriority(9);
		StarvationDemo t3 = new StarvationDemo("Three");
		t3.setPriority(8);
		StarvationDemo t4 = new StarvationDemo("Four");
		t4.setPriority(7);
		StarvationDemo t5 = new StarvationDemo("Five");
		t5.setPriority(6);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		t5 having the least priority waits until all the threads complete execution,
//		as it has lowest priority, so might suffer starvation, not guaranteed although
		t5.start();
	}

}

