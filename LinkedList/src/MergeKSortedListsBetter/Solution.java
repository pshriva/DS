package MergeKSortedListsBetter;
//LCA
public class Solution {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		one.next = new ListNode(4);
		one.next.next = new ListNode(5);
		ListNode two = new ListNode(1);
		two.next = new ListNode(3);
		two.next.next = new ListNode(4);
		ListNode three = new ListNode(2);
		three.next = new ListNode(6);
		ListNode result = mergeLists(new ListNode[] {one, two, three});
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
//		System.out.println("ok***");
//		while(three != null){
//			System.out.println(three.val);
//			three = three.next;
//		}
	}

	private static ListNode mergeLists(ListNode[] listNodes) {
		return partition(listNodes, 0, listNodes.length -1);
	}

	private static ListNode partition(ListNode[] listNodes, int start, int end) {
		if(start == end){return listNodes[start];}
		while(start < end){
			int mid = start + (end-start)/2;
			ListNode l1 = partition(listNodes, start, mid);
			ListNode l2 = partition(listNodes, mid+1, end);
			return merge(l1, l2);
		}
		return null;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null){return l2;}
		if(l2 == null){return l1;}
		ListNode result = new ListNode(0);
		ListNode start = result;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
//	This merging is better than the previous merging approach	
		while(curr1 != null && curr2 != null){
			if(curr1.val < curr2.val){
				result.next = curr1;
				curr1 = curr1.next;
			}else{
				result.next = curr2;
				curr2 = curr2.next;
			}
			result = result.next;
		}
		if(curr1 != null){result.next = curr1;}
		if(curr2 != null){result.next = curr2;}
		return start.next;
	}

}
