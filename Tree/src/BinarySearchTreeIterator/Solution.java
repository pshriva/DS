package BinarySearchTreeIterator;

public class Solution {
	public static void main(String [] args){
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(40);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(30);
		root.right = new TreeNode(90);
		root.right.left = new TreeNode(70);
		root.right.right = new TreeNode(100);
		BSTIterator biter = new BSTIterator(root);
		while(biter.hasNext()){
			System.out.println(biter.next());
		}
	}
}
