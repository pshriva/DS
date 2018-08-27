package MergeTwoSortedLists;

public class Solution {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(0);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(7);
		l1.next.next.next.next = new ListNode(9);
		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(10);
		l1 = getMergedList(l1, l2);
		while(l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}
	
// Leetcode accepted, beats 100% of solutions
	private static ListNode getMergedList(ListNode l1, ListNode l2) {
		if(l1 == null) {return l2;}
		if(l2 == null) {return l1;}
		ListNode start = null;
		ListNode prev = null;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		while(curr1 != null && curr2 != null) {
			if(curr1.val >= curr2.val) {
				ListNode temp = curr2;
				curr2 = curr2.next;
				if(prev != null) {
					prev.next = temp;
					temp.next = curr1;
					prev = temp;
				}else {
					prev = temp;
					prev.next = curr1;
					start = prev;
				}
			}
			else {
				if(prev == null) {start = curr1;}
				prev = curr1;
				curr1 = curr1.next;
			}
		}
		if(curr2 != null) {prev.next = curr2;}
		
		return start;
	}
}
