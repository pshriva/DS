package BalancedBinaryTree;

public class Solution {
	public static void main(String args[]) {
		BST bst = new BST();
		bst.root = new Node(1);
		bst.root.left = new Node(2);
		bst.root.right = new Node(2);
		bst.root.left.left = new Node(3);
		bst.root.right.right = new Node(3);
		bst.root.left.left.left = new Node(4);
		bst.root.right.right.right = new Node(4);
//		BST bst = new BST();
//		bst.root = new Node(3);
//		bst.root.left = new Node(9);
//		bst.root.right = new Node(20);
//		bst.root.right.left = new Node(15);
//		bst.root.right.right = new Node(7);
		boolean isBalanced = isBalanced(bst.root);
		System.out.println(isBalanced);
	}

	//LCA
//	private static boolean isBalanced(Node root) {
//		if(root == null) {return true;}
//		int leftHeight = getHeight(root.left);
//		int rightHeight = getHeight(root.right);
//		if(Math.abs(leftHeight - rightHeight) > 1) {return false;}
//		return isBalanced(root.left) && isBalanced(root.right);
//	}
//
//	private static int getHeight(Node root) {
//		if(root == null) {return -1;}
//		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//	}
	
//LCA
	
	private static boolean isBalanced(Node root) {
		if(root == null) {return true;}
		return getHeight(root) != - 1;
	}

	private static int getHeight(Node root) {
		if(root == null) {return 0;}
		int leftHeight = getHeight(root.left);
		if(leftHeight == -1) {return -1;}
		int rightHeight = getHeight(root.right);
		if(rightHeight == -1) {return -1;}
		if(Math.abs(leftHeight - rightHeight) > 1) {return -1;}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
