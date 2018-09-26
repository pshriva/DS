package RemoveDuplicatesFromSortedList;
//LCA
public class Solution {
	public static void main(String args[]){
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(3);
		removeDuplicates(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static void removeDuplicates(Node head) {
		Node temp = head;
		Node prev = head;
		while(temp != null){
			if(temp != prev && temp.val == prev.val){prev.next = temp.next;}
			else{prev = temp;}
			temp = temp.next;
		}
	}
}
