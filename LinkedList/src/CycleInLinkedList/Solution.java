package CycleInLinkedList;

public class Solution {
	public static void main(String []arags){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = head.next.next;
		boolean hasCycle = determineCycle(head);
		System.out.println(hasCycle);
	}
//	private static boolean determineCycle(Node head) {
//		if(head == null){return false;}
//		Node slow = head;
//		Node fast = head.next;
//		while(slow != null && fast != null){
//			if(slow == fast){return true;}
//			slow = slow.next;
//			if(fast.next == null){return false;}
//			fast = fast.next.next;
//		}
//		return true;
//	}

	private static boolean determineCycle(Node head) {
        if(head == null){return false;}
		Node slow = head;
		Node fast = head.next;
		while(slow != null && fast != null){
			if(slow == fast){return true;}
			slow = slow.next;
			if(fast.next == null){return false;}
			fast = fast.next.next;
		}
		return false;
    }
}
