package ClosestBinarySearchTreeValue;

import java.util.*;

public class Solution {
	static int result;
	public static void main(String[] args) {
		Node root = new Node(9);
		root.left = new Node(4);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right = new Node(17);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);
		int target = 8;
		int closestNodevalue = getClosestNodeValue(root, target);
		System.out.println(closestNodevalue);
	}
	
	
//	Recursive
//	private static int getClosestNodeValue(Node root, int target) {
//		getClosestNodeValue(root, target, Integer.MAX_VALUE);
//		return result;
//	}
//
//	private static void getClosestNodeValue(Node root, int target, int min) {
//		if(root == null){return;}
//		if(Math.abs(target - root.val) < min){
//			min = Math.abs(target - root.val);
//			result = root.val;
//		}
////		if(target == root.val){
////			result = root.val;
////			return;
////		}
//		if(target < root.val){getClosestNodeValue(root.left, target, min);}
//		else{getClosestNodeValue(root.right, target, min);}
//	}

	
//	Iterative
//	private static int getClosestNodeValue(Node root, int target) {
//		if(root == null){return -1;}
//		int minDiff = Integer.MAX_VALUE;
//		int result = root.val;
//		Node temp = root;
//		while(temp != null){
//			if(target == temp.val){return target;}
//			int diff = Math.abs(temp.val - target);
//			if(diff < minDiff){
//				minDiff = diff;
//				result = temp.val;
//			}
//			if(target < temp.val){temp = temp.left;}
//			else{temp =temp.right;}
//		}
//		return result;
//	}
	
//	Iterative
	private static int getClosestNodeValue(Node root, int target) {
		if(root == null){return -1;}
		int result = root.val;
		Node temp = root;
		while(temp != null){
			if(Math.abs(result - target)>=Math.abs(temp.val - target)){
				result = temp.val;
			}
			temp = target < temp.val ? temp.left : temp.right; 
		}
		return result;
	}

}
