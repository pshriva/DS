package LowestCommonAncestorOfBST;

public class Solution {
	public static void main(String args[]){
		BST bst = new BST();
		bst.root = new Node(6);
		bst.root.left = new Node(2);
		bst.root.left.left = new Node(0);
		bst.root.left.right = new Node(4);
		bst.root.left.right.left = new Node(3);
		bst.root.left.right.right = new Node(5);
		bst.root.right = new Node(8);
		bst.root.right.left = new Node(7);
		bst.root.right.right = new Node(9);
		Node ancestor = bst.getLowestCommonAncestor(bst.root.left.right.right, bst.root.left.left);
		if(ancestor != null){
			System.out.println(ancestor.val);
		}
		else{System.out.println("No common ancestor found");}
	}
}
