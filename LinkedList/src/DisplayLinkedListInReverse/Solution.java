package DisplayLinkedListInReverse;

public class Solution {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(5);
		list.head.next = new Node(7);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(100);
		list.head.next.next.next.next = new Node(89);
		list.head.next.next.next.next.next = new Node(10);
		System.out.println("Linkedlist is ");
		list.display();
		System.out.println("List displayed in reverse");
		list.displayInReverse();
	}

}
