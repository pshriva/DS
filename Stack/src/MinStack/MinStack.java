package MinStack;
//LCA
public class MinStack {
	Node head;
	public void push(int val) {
		if(head == null){
			head = new Node(val, val, head);
		}else{
			head = new Node(val, Math.min(val, head.min), head);
		}
	}
	public void pop() {
		head = head.next;
	}
	public int top() {
		return head.val;
	}
	public int getMin() {
		return head.min;
	}
	
}
