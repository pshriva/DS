package MergeKSortedLists;

// see time complexity in geekforgeeks - O[nklogk], n =  size of each list, k = size of array of lists(total number of lists)
public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode l4 = new ListNode(7);
		l4.next = new ListNode(9);
		ListNode l5 = new ListNode(-9);
		l5.next = new ListNode(10);
		l5.next.next = new ListNode(15);
		l5.next.next.next = new ListNode(17);
		l5.next.next.next.next = new ListNode(20);
		ListNode[] lists = {l1,l2,l3,l4,l5};
		l1 = getMergedLists(lists);
		ListNode temp = l1;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	//	private static ListNode getMergedLists(ListNode[] lists) {
	//	if(lists.length == 0) {return null;}
	//	ListNode first = lists[0];
	//	int x = 1;
	//	while(x < lists.length) {
	//		first = merge(first, lists[x]);
	//		x++;
	//	}
	//	return first;
	//}
	
	private static ListNode getMergedLists(ListNode[] lists) {
		return partition(lists, 0, lists.length-1);
	}
	
	private static ListNode partition(ListNode[] lists, int start, int end) {
		if(start == end) {return lists[start];}
		while(start < end) {
			int mid = start + (end-start)/2;
			ListNode l1 = partition(lists, start, mid);
			ListNode l2 = partition(lists, mid+1, end);
			return(merge(l1, l2));
		}
		return null;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
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
				if(prev == null) {
					prev = temp;
					prev.next = curr1;
					start = prev;
				}else {
					prev.next = temp;
					prev = temp;
					prev.next = curr1;
				}
			}else {
				if(prev == null) {
					start = curr1;
				}
				prev = curr1;
				curr1 = curr1.next;
			}
		}
		if(curr2 != null) {
			prev.next = curr2;
		}
		return start;
	}
	

}
