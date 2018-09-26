package SerializeAndDeserializeBinaryTree;

public class Solution {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		Algorithm algo = new Algorithm();
		String coded = algo.serialize(root);
		System.out.println(coded);
		TreeNode t = algo.deserialize(coded);
		algo.InorderTraversal(t);
	}
}
