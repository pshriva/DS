package ReverseNodesInKGroups;
//LCA
public class Solution {
	public static void main(String args[]){
		ListNode root = new ListNode(2);
		root.next = new ListNode(3);
		root.next.next = new ListNode(4);
		root.next.next.next = new ListNode(5);
		root.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next.next = new ListNode(8);
		root.next.next.next.next.next.next.next = new ListNode(9);
		int k = 3;
		root = reverseKNodes(root, k);
		while(root != null){
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	private static ListNode reverseKNodes(ListNode head, int k) {
		int len = 0;
		ListNode curr = head;
		while(curr != null){
			curr= curr.next;
			len++;
		}
		if(k > len){return head;}
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode prev2 = start;
		ListNode prev = head;
		for(int i = 0; i<len/k; i++){
			for(int j = 0; j < k-1; j++){
				ListNode temp = prev.next;
				prev.next = temp.next;
				temp.next = prev2.next;
				prev2.next = temp;
			}
			prev2 = prev;
			prev = prev2.next;
		}
		return start.next;
	}
}
