package ReverseLinkedList;



public class Solution {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	public static void main(String args[]) {
		Node l = new Node(5);
		l.next = new Node(4);
		l.next.next = new Node(7);
		l.next.next.next = new Node(15);
		Node temp = l;
		System.out.println("Before reversing");
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
		System.out.println("After reversing");
		Node current = l;
		temp = null;
		Node previous = null;
		while(current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		temp = previous;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
