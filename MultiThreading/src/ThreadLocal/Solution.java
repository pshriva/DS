package ThreadLocal;
// From notes
public class Solution extends Thread{
//This threadLocal stores the local attributes of the current thread (Main thread)
//	public static void main(String[] args) {
//		ThreadLocal tl = new ThreadLocal();
//		System.out.println(tl.get());
//		tl.set(1);
//		System.out.println(tl.get());
//		tl.remove();
//		System.out.println(tl.get());
//	}
	
	
//	Demonstration of ThreadLocal
//	public static void main(String args[]){
//		CustomThread ct = new CustomThread();
//		Thread t1 = new Thread(ct, "One");
//		Thread t2 = new Thread(ct, "Two");
//		t1.start();
//		t2.start();
//	}
	
//	ThreadLocal with respect to interitance, the child thread will not have access to parent thread attributes
//	public static void main(String[]arg){
//		ParentThread pt = new ParentThread();
//		Thread pt1 = new Thread(pt, "ParentThread");
//		pt1.start();
//	}

//	To overcome the limitation in above, i.e. to get the parent 'ThreadLocal attribute value' in the child thread,
//	we use InteritableThreadLocal rather than ThreadLocal
	public static void main(String args[]){
//		Either create the object itself as thread and then in the InheritableTLParentThread class, use super to name the thread, this is when the object is itself the single thread
//		or use Thread t = new Thread(ipt, "name") as in the above example, this is useful to create more then one threads of ipt object
		InheritableTLParentThread ipt = new InheritableTLParentThread("ParentThread");
		ipt.start();
	}
}
