package ThreadLocal;

public class CustomThread extends Thread{
// Creating the ThreadLocal for any thread of any object of this class
	static int custId = 0;
//	Either use the tl.set(++custId) method in the run() method, to set the initial value, or use as below
	private static ThreadLocal tl = new ThreadLocal(){
		public Object initialValue(){
			return ++custId;
		}
	};
	public void run(){
		System.out.println(Thread.currentThread().getName() + " is running with CustId as " + tl.get());
	}
}
