package Suspend;

public class CustomPrinter extends Thread{
	Printer p;
	public CustomPrinter(String name, Printer p){
		super(name);
		this.p = p;
	}
	public void run(){
		p.print();
		System.out.println(this.getName() + " hasa finished execution");
	}
	
}
