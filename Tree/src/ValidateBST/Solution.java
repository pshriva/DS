package ValidateBST;
//LCA
public class Solution {
	public static void main(String args[]) {
		BST bst = new BST();
		bst.root = new Node(50);
		bst.root.left = new Node(40);
		bst.root.right = new Node(70);
		bst.root.left.left = new Node(20);
		bst.root.left.right = new Node(45);
		bst.root.right.left = new Node(60);
		bst.root.right.right = new Node(90);
		boolean isBST = bst.isBinarySearchTree();
		System.out.println(isBST);
	}
}
