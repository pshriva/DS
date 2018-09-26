package RemoveNthElementFromEndOfLinkedList;
//LCA
public class Solution {
	public static void main(String []args){
//		Node head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);
		Node head = new Node(3);
		int n = 3;
		Node result = removeNthNodeFromEnd(head, n);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

	private static Node removeNthNodeFromEnd(Node head, int n) {
		Node start = new Node(0);
		start.next = head;
		Node fast = start;
		Node slow = start;
		for(int i = 0; i<=n;i++){
			if(fast == null){return head;}
			fast = fast.next;
		}
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return start.next;
	}
}
