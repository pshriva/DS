package WaitNotifyNotifyAll;

import java.util.Queue;

public class MyProducer extends Thread{
	Queue<String> q;
	
	public MyProducer(Queue q){
		this.q = q;
	}
	
	public void run(){
		synchronized(q){
			q.add("Item i");
//			notify any waiting consumer thread that there are now items in the queue, so the consumer thread could resume
			q.notify();
			//If there are more than 1 consumers then , we could use q.notifyall(), so that based on JVM, one by one, each cosumer could be notified of the item
		}
	}
}
