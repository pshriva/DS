package PopulatingNextRightPointerInEachNode;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		generateNextPointer(root);
		System.out.println(root.right.right.next);
	}
// LCA for a complete binary tree
//	private static void generateNextPointer(TreeNode root) {
//		if(root == null){return;}
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.add(root);
//		while(!queue.isEmpty()){
//			int size = queue.size();
//			TreeNode prev = null;
//			for(int i = 0; i< size; i++){
//				TreeNode n = queue.poll();
//				if(n.left != null){queue.add(n.left);}
//				if(n.right != null){queue.add(n.right);}
//				if(prev == null){prev = n;}
//				else{
//					prev.next = n;
//					prev = n;
//				}
//			}
//		}
//	}
	
//FOR an incomplete any other binary tree:
//	https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
	private static void generateNextPointer(TreeNode root) {
		TreeNode first = null;
		TreeNode last = null;
		TreeNode curr = root;
//		For the whole tree
		while(curr != null){
//			 For each level
			while(curr != null){
//				For left child
				if(curr.left != null){
					if(last != null){
						last.next = curr.left;
					}else{
						first = curr.left;
					}
					last = curr.left;
				}
//				 For right child
				if(curr.right != null){
					if(last != null){
						last.next = curr.right;
					}else{
						first = curr.right;
					}
					last = curr.right;
				}
				curr = curr.next;
			}
			curr = first;
			first = null;
			last = null;
		}
	}
}
