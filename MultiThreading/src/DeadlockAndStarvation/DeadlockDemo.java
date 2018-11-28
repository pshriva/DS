package DeadlockAndStarvation;
// Stop this program manually from running, as it is an example of deadlock, so it never terminates
public class DeadlockDemo extends Thread{
	static Thread t;
	public void run(){
		System.out.println("Waiting for main thread to finish");
		try {
			t.join();
			System.out.println("Main thread finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		t = Thread.currentThread();
		DeadlockDemo dl = new DeadlockDemo();
		dl.start();
		System.out.println("Waiting for dl to finish");
		dl.join();
		System.out.println("dl thread finished");
	}

}
