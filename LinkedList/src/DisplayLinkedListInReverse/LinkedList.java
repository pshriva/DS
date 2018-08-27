package DisplayLinkedListInReverse;

public class LinkedList {
	Node head;
	public LinkedList() {
		this.head = null;
	}
	public void display() {
		if(head == null) {System.out.println("List is empty"); return;}
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	public void displayInReverse() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		displayInReverse(head);
	}
	private void displayInReverse(Node curr) {
		if(curr == null) {return;}
		displayInReverse(curr.next);
		System.out.println(curr.value);
	}
	
}
