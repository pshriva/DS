package DoublyLinkedList;

public class Solution {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(5);
		list.insert(7);
		list.insert(4);
		list.insert(89);
		list.insert(10);
		list.display();
		System.out.println("AFter adding the element");
		int value = 100;
		int index = 3;
		list.insertAtIndex(index,value);
		list.display();
		System.out.println("After deleting from index");
		index = 3;
		list.deleteFromIndex(index);
		list.display();
		System.out.println("Displaying the list in reverse");
		list.displayInReverse();
	}

}
