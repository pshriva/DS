package MergeKSortedListsBest;

import java.util.*;
//LCA

// Inserting or removing an element from priority queue is O(log(n)), so for all n elements is - O(nlog(n))
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
	}

	private static ListNode mergeLists(ListNode[] listNodes) {
		Queue<ListNode> queue = new PriorityQueue<>((a, b)-> (a.val - b.val));
		ListNode result = new ListNode(0);
		ListNode start = result;
		for(ListNode n : listNodes){
			if(n != null){queue.add(n);}
		}
		while(!queue.isEmpty()){
			result.next = queue.poll();
			result = result.next;
			if(result.next != null){queue.add(result.next);}
		}
		return start.next;
	}

}
