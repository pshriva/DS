package ThreadLocal;

public class InheritableTLParentThread extends Thread{
//	type String is mentioned to the attribute value, we can also create one, without the type and can then put any object type into it
//	public static InheritableThreadLocal tl = new InheritableThreadLocal();
//	Without inheriting the childValue method, the tl.get() in child class will give parent attribute value
//	public static InheritableThreadLocal<String> tl = new InheritableThreadLocal<>();
	
//	With inheriting the childValue method, the child attribute will have the child value as:
	public static InheritableThreadLocal tl = new InheritableThreadLocal(){
		public Object childValue(Object parentValue){
			return "childValue";
		}
	};
	public InheritableTLParentThread(String name){
		super(name);
	}
	public void run(){
		tl.set("ParentTLValue");
		System.out.println(Thread.currentThread().getName() + " is executing with TL attribute value as: " + tl.get());
		InheritableTLChildThread ict = new InheritableTLChildThread("ChildThread");
		ict.start();
	}
}
