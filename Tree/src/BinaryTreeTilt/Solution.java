package BinaryTreeTilt;

import java.util.LinkedList;
import java.util.Queue;
//LCA
public class Solution {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int tilt = getTreeTilt(root);
		System.out.println(tilt);
	}
//LCA	
	private static int getTreeTilt(Node root) {
		int[] tilt = new int[1];
		getTilt(root, tilt);
		return tilt[0];
	}

	private static int getTilt(Node node, int[] tilt) {
		if(node == null){return 0;}
		int leftSum = getTilt(node.left, tilt);
		int rightSum = getTilt(node.right, tilt);
		tilt[0] = tilt[0] + Math.abs(leftSum - rightSum);
		return node.val + leftSum + rightSum;
	}

//LCA
//	private static int getTreeTilt(Node root) {
//		if(root == null){return 0;}
//		int tilt = 0;
//		Queue<Node> queue = new LinkedList<>();
//		queue.add(root);
//		while(!queue.isEmpty()){
//			Node n = queue.poll();
//			int leftSum = getSum(n.left);
//			int rightSum = getSum(n.right);
//			tilt = tilt + Math.abs(leftSum - rightSum); 
//			if(n.left != null){queue.add(n.left);}
//			if(n.right != null){queue.add(n.right);}
//		}
//		return tilt;
//	}
//
//	private static int getSum(Node node) {
//		if(node == null){return 0;}
//		int sum = 0;
//		Queue<Node> queue = new LinkedList<>();
//		queue.add(node);
//		while(!queue.isEmpty()){
//			Node n = queue.poll();
//			sum = sum + n.val;
//			if(n.left != null){queue.add(n.left);}
//			if(n.right != null){queue.add(n.right);}
//		}
//		return sum;
//	}

	
}
