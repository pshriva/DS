package BasicUsingRunnable;

public class RunnableDemo implements Runnable {

	public static void main(String[] args) {
		RunnableDemo r1 = new RunnableDemo();
		RunnableDemo r2 = new RunnableDemo();
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r2, "Thread2");
		r1.start();
		r2.start();
	}

	private void start() {
		System.out.println("Starting " + this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running " + this);
	}

}
