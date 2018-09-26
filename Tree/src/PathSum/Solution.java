package PathSum;
//LCA
public class Solution {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(11);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(2);
		root.right.left = new Node(13);
		root.right.right = new Node(4);
		root.right.right.right = new Node(1);
		int sum = 22;
		boolean sumExists = hasSum(root, sum);
		System.out.println(sumExists);
	}

	private static boolean hasSum(Node root, int sum) {
		return root != null && ((root.left == null && root.right == null && root.val == sum)
								|| hasSum(root.left, sum-root.val)
								|| hasSum(root.right, sum - root.val));
	}

}
