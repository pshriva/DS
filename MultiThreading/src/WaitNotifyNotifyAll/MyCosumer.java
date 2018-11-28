package WaitNotifyNotifyAll;

import java.util.Queue;

public class MyCosumer extends Thread{
	Queue<String> q;
	
	public MyCosumer(Queue q){
		this.q = q;
	}
	
	public void run(){
		synchronized(q){
			if(!q.isEmpty()){
				System.out.println("Consuming " + q.remove());
			}else{
				try {
//					putting this in waiting, so the producer thread can put some item in the queue and notify the conusmer
					q.wait();
					System.out.println("Consuming " + q.remove());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
