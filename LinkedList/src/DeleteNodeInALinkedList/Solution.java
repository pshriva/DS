package DeleteNodeInALinkedList;
/*
 * A function to delete a node from a linkedlist given access to only that node,
 * provided that it is not the tail node
 */

//LCA
public class Solution {
	public static void main(String args[]){
		Node head = new Node(4);
		head.next = new Node(5);
		head.next.next = new Node(1);
		head.next.next.next = new Node(9);
		deleteNode(head.next);
		Node temp = head;
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

//	private static void deleteNode(Node node) {
//		node.val = node.next.val;
//		node.next = node.next.next;
//	}
	
	private static void deleteNode(Node node) {
		if(node.next == null){return;}
		node.val = node.next.val;
		if(node.next.next != null){
			node.next = node.next.next;
		}else{
			node.next = null;
		}
	}
}
