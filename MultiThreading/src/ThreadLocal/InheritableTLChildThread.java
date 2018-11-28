package ThreadLocal;

public class InheritableTLChildThread extends InheritableTLParentThread{
	public InheritableTLChildThread(String name){
		super(name);
	}
	public void run(){
		System.out.println(Thread.currentThread().getName() + " is executing with TL attribute value inherited from Parent thread as: " + tl.get());
	}
}
