package SwapNodesInPairs;

//LC accepted
public class Solution {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
//		list.next.next.next.next = new ListNode(5);
		list = getSwapPairedList(list);
		ListNode temp = list;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	private static ListNode getSwapPairedList(ListNode list) {
		if(list == null) {return null;}
		ListNode first = list;
		ListNode start = null;
		ListNode prev = new ListNode(0);
		while(first.next != null) {
			ListNode second = first.next;
			ListNode temp = second.next;
			second.next = first;
			first.next = temp;
			prev.next = second;
			if(start == null) {start = second;}
			prev = first;
			first = first.next != null ? first.next : first;
		}
		return start;
	}

}
