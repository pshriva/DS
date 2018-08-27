package DoublyLinkedList;

public class LinkedList {
	Node head;
	public LinkedList() {head = null;}
	public void insert(int i) {
		if(head == null) {
			head = new Node(5);
			return;
		}
		Node prev = null;
		Node temp = head;
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev = temp;
		temp.next = new Node(i);
		temp = temp.next;
		temp.prev = prev;
	}
	public void display() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp =temp.next;
		}
	}
	public void insertAtIndex(int i, int value) {
		if(head == null && i > 0) {
			System.out.println("Index too large");
			return;
		}
		int curr = 0;
		Node temp = head;
		while(temp.next != null && curr < i-1) {
			temp = temp.next;
			curr++;
		}
		if(curr != i-1) {System.out.println("Index too large"); return;}
		Node newElement = new Node(value);
		Node next = temp.next;
		newElement.prev = temp;
		temp.next = newElement;
		newElement.next = next;
		if(next != null) {next.prev = newElement;}
		
	}
	public void deleteFromIndex(int index) {
		if(head == null) {System.out.println("List is empty"); return;}
		Node curr = head;
		int i = 0;
		while(i != index && curr.next != null) {
			curr = curr.next;
			i++;
		}
		if(i != index) {
			System.out.println("Index too large");
			return;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
	}
	public void displayInReverse() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp.next != null) {temp = temp.next;}
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.prev;
		}
	}
	
}
