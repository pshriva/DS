package LRUCache;

import java.util.*;

public class LRUCache {
	class Node{
		int key;
		int val;
		Node prev;
		Node next;
		public Node(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	
	Map<Integer, Node> map;
	Node head;
	Node tail;
	int capacity;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	public int get(int key){
		if(map.containsKey(key)){
//			if it is not the head, move to the head and return
			Node n = map.get(key);
			if(n.prev != null){
//				If it is tail, remove it, make the prev as tail
				if(n.next == null){
					tail = n.prev;
					tail.next = null;
				}else{
//					If it is not tail, remove this node and put it as head
					n.prev.next = n.next;
					n.next.prev = n.prev;
				}
//				Set it as head
				n.prev = null;
				head.prev = n;
				n.next = head;
				head = n;
			}
			return map.get(key).val;
		}
		return -1;
	}
	
	
	public void put(int key, int val){
//		If the key is already present, just move it's node to head by calling above get function and update the value
		if(map.containsKey(key)){
			get(key);
			map.get(key).val = val;
			return;
		}
//		If the capacity is full, just remove the tail
		if(map.size() == capacity){
//			if head and tail point at the same element
			if(tail.prev != null){
				int lastKey = tail.key;
				map.remove(lastKey);
				tail = tail.prev;
				tail.next = null;
			}else{
				int lastKey = tail.key;
				map.remove(lastKey);
				tail = null;
				head = null;
			}
		}
		Node n = new Node(key, val);
		map.put(key, n);
		if(head == null){
			head = n;
			tail = n;
		}else{
			n.next = head;
			head.prev = n;
			head = n;
		}
	}
}
