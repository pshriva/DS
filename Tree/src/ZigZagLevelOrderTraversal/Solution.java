package ZigZagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String []args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = getZigZagLevelOrderTraversal(root);
		System.out.println(result);
	}

	private static List<List<Integer>> getZigZagLevelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){return result;}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			List<Integer> current = new ArrayList<>();
			while(!s1.isEmpty()){
				TreeNode n = s1.pop();
				if(n.left != null){s2.push(n.left);}
				if(n.right != null){s2.push(n.right);}
				current.add(n.val);
			}
			result.add(current);
			current = new ArrayList<>();
			while(!s2.isEmpty()){
				TreeNode n = s2.pop();
				if(n.right != null){s1.push(n.right);}
				if(n.left != null){s1.push(n.left);}
				current.add(n.val);
			}
			if(current.size() > 0)result.add(current);
		}
		return result;
	}
}
