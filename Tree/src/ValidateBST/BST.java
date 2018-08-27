package ValidateBST;

public class BST {
	Node root;

	public boolean isBinarySearchTree() {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isBST(Node root, long min, long max) {
		if(root == null) {return true;}
		if(min < root.value && root.value < max) {
			return (isBST(root.left, min, root.value) && isBST(root.right, root.value, max));
		}
		return false;
	}
}
