package ThreadLocal;

public class ChildThread extends ParentThread{
	public void run(){
		System.out.println(Thread.currentThread().getName() + " is executing and threadlocal value inherited from parent is " + tl.get());
	}
}
