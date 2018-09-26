package LowestCommonAncestorOfBinaryTree;

public class Solution {
	public static void main(String args[]){
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(5);
		bt.root.left.left = new Node(6);
		bt.root.left.right = new Node(2);
		bt.root.left.right.left = new Node(7);
		bt.root.left.right.right = new Node(4);
		bt.root.right = new Node(1);
		bt.root.right.left = new Node(0);
		bt.root.right.right = new Node(8);
		Node ancestor = bt.getLowestAncestor(bt.root, bt.root.left.left, bt.root.left.right.right);
		if(ancestor != null){
			System.out.println(ancestor.val);
		}else{
			System.out.println("Ancestor is null");
		}
		
	}
}
