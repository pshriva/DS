package WaitNotifyNotifyAll;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		MyQueue queue = new MyQueue(q);
		MyCosumer c = new MyCosumer(q);
		MyProducer p = new MyProducer(q);
		c.start();
		p.start();
	}

}
