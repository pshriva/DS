package MiniumDepthOfBinaryTree;
//LCA
public class Solution {
	public static void main(String []args){
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		int minDepth = getMinDepth(root);
		System.out.println(minDepth);
	}

	private static int getMinDepth(Node root) {
		if(root == null){return 0;}
		int left = getMinDepth(root.left);
		int right = getMinDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
