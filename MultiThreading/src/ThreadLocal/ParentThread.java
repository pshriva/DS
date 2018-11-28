package ThreadLocal;

public class ParentThread extends Thread{
	public static ThreadLocal tl = new ThreadLocal();
	public void run(){
		tl.set(1);
		System.out.println(Thread.currentThread().getName() +" is executing with ThreadLocalValue " + tl.get());
		ChildThread ct = new ChildThread();
		Thread ct1 = new Thread(ct, "ChildThread");
		ct1.start();
	}
}
