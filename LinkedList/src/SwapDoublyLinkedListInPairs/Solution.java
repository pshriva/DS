package SwapDoublyLinkedListInPairs;

public class Solution {
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.print();
		System.out.println("Swapping pairwise");
		list.swapNodes();
		list.print();
	}
}
