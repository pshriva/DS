package BinarySearchTreeIterator;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root){
		stack = new Stack<>();
		TreeNode curr = root;
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
		TreeNode curr = stack.pop();
		putNextInStaack(curr);
		return curr.value;
	}
	private void putNextInStaack(TreeNode curr) {
		curr = curr.right;
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
	}
}
