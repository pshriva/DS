package SymmetricTree;
//LCA
public class Solution {
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		boolean isSymmetric = isSymmetric(root);
		System.out.println(isSymmetric);
	}

	private static boolean isSymmetric(Node root) {
		if(root == null){return true;}
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(Node leftRoot, Node rightRoot) {
		if(leftRoot == null && rightRoot == null){return true;}
		if(leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val){return false;}
		return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left);
	}
}
