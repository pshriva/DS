package SwapDoublyLinkedListInPairs;

public class LinkedList {
	Node head;
	public void insert(int i){
		if(head == null){
			head = new Node(i);
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		Node prev = temp;
		temp.next = new Node(i);
		temp = temp.next;
		temp.prev = prev;
	}
	public void print() {
		Node temp = head;
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	public void swapNodes() {
		if(head == null){return;}
		Node first = head;
		Node prev = new Node(0);
		Node start = null;
		while(first.next != null){
			Node second = first.next;
			Node temp = second.next;
			second.next = first;
			second.prev = prev;
			prev.next = second;
			first.prev = second;
			first.next = temp;
			if(temp != null)temp.prev = first;
			prev = first;
			if(start == null){start = second;}
			first = first.next != null ? first.next : first;
		}
		head = start;
	}
}
