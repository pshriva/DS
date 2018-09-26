package ReverseLinkedList;

public class Solution {
	public static void main(String [] args){
		Node l = new Node(1);
		l.next = new Node(2);
		l.next.next = new Node(3);
		l.next.next.next = new Node(4);
		l.next.next.next.next = new Node(5);
		Node reversed = getReverseLinkedList(l);
		Node temp = reversed;
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	private static Node getReverseLinkedList(Node l) {
		if(l == null){return l;}
		Node curr = l;
		Node prev = null;
		while(curr != null){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
}

