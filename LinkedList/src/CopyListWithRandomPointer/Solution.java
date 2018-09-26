package CopyListWithRandomPointer;

import java.util.*;

//LCA
public class Solution {
	public static void main(String args[]){
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(1, new ArrayList<>(Arrays.asList(2,3,4)));
		List<Integer> l = map.get(1);
		l.add(7);
//		map.put(1,  map.get(1).add(6));
//		Node head = new Node(-1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);
//		head.random = head.next.next;
//		
//		head.next.random = head;
//		head.next.next.random = head.next.next.next.next;
//		head.next.next.next.random = head.next.next;
//		head.next.next.next.next.random = head.next;
//		Node head2 = copyLinkedList(head);
//		while(head2 != null){
//			System.out.print(head2.val + " ");
//			if(head2.random != null){
//				System.out.println(head2.random.val);
//			}
//			head2 = head2.next;
//		}
	}

	private static Node copyLinkedList(Node head) {
		if(head == null){return null;}
		Node curr = head;
		while(curr != null){
			Node next = new Node(curr.val);
			Node temp = curr.next;
			curr.next = next;
			next.next = temp;
			curr = temp;
		}
		curr = head;
		while(curr.next != null){
			if(curr.random == null){curr.next.random = null;}
			else{curr.next.random = curr.random.next;}
			curr = curr.next.next;
			if(curr == null){break;}
		}
		Node h2 = head.next;
		Node temp1 = head;
		Node temp2 = h2;
		while(temp2.next != null){
			temp1.next = temp2.next;
			temp1 = temp2.next;
			temp2.next = temp1.next;
			temp2 = temp1.next;
		}
		temp1.next = null;
//		Node h2 = null;
		return h2;
	}
}
