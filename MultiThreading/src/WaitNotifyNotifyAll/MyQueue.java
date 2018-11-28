package WaitNotifyNotifyAll;

import java.util.*;

public class MyQueue {
	Queue<String> queue;
	public MyQueue(Queue queue){
		this.queue = queue;
	}
	
	public synchronized String getItem(){
		return queue.poll();
	}
	
	public synchronized void putItem(String item){
		queue.offer(item);
	}
}
