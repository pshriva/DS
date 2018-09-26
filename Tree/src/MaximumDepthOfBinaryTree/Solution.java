package MaximumDepthOfBinaryTree;
//LCA
public class Solution {
	public static void main(String []args){
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		int maxDepth = getMaxDepth(root);
		System.out.println(maxDepth);
	}

	private static int getMaxDepth(Node root) {
		if(root == null){return 0;}
		return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
	}
}
