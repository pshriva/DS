package treeOperations;

//For all traversals, TC = O(n), BFS, DFS, and Inorder, Preorder, Postorder
public class Solution {
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(40);
		bst.insert(60);
		bst.insert(45);
		bst.insert(30);
		bst.insert(70);
		bst.insert(25);
		bst.insert(65);
		bst.insert(67);
		bst.insert(75);
		bst.insert(80);
		bst.insert(55);
		bst.insert(27);
//		System.out.println("-----BFS-----");
//		bst.getBFS();
//		System.out.println("-----DFS-----");
//		bst.getDFS();
//		int element = 41;
//		System.out.println("----- Does the tree contain the element " + element + "? : " + bst.search(element));
//		System.out.println("-----Height of the tree: " + bst.getHeight());
//		System.out.println("----- Zig-Zag traversal -----");
//		bst.getZigZagTraversal();
//		System.out.println("----- Tree is a Binary Search Tree? : " + bst.isBinarySearchTree());
//		System.out.println("Adding extra non-binary node");
//		bst.root.left.right.right = new Node(10);
//		System.out.println("----- Tree is a Binary Search Tree? : " + bst.isBinarySearchTree());
//		System.out.println("Removing extra non-binary node");
//		bst.root.left.right.right = null;
//		System.out.println("----- Tree is a Binary Search Tree? : " + bst.isBinarySearchTree());
//		element = 67;
//		System.out.println("After deleting the element " + element + " the bfs sequesnce is :");
//		bst.removeElement(0);
//		bst.getBFS();
//		System.out.println("----- Inorder traversal -----");
//		bst.getInordertraversal();
//		System.out.println("----- Pre-order traversal -----");
//		bst.getPreorderTraversal();
//		System.out.println("----- Post-order traversal -----");
//		bst.getPostorderTraversal();
		Node n = bst.getInorderSuccessor(bst.root.left.left);
		if(n != null) {System.out.println(n.value);}
	}
}
