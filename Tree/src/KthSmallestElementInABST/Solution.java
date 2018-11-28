package KthSmallestElementInABST;

import java.util.*;
//LCA
public class Solution {

	public static void main(String[] args) {
		System.out.println("Hi");
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(6);
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.right = new TreeNode(8);
//		root.right.right = new TreeNode(9);
//		root.right.left = new TreeNode(7);
//		root.right.left.left = new TreeNode(6);
		int k = 3;
		int kthSmallestElement = getKthSmallestElement(root, k);
		System.out.println(kthSmallestElement);
	}
	
//	Followup - when the nodes are frequently being inserted and deleted
	private static int getKthSmallestElement(TreeNode root, int k) {
		Map<TreeNode, Integer> map = new HashMap<>();
		getSmallerNodesCount(root, map);
		for(TreeNode key : map.keySet()){
			System.out.println(key.val + " " + map.get(key));
		}
		return getKthSmallestElement(root, k, map);
	}
	
	private static int getKthSmallestElement(TreeNode root, int k, Map<TreeNode, Integer> map) {
		int leftLength = root.left != null ? map.get(root.left) : 0;
		if(k == leftLength + 1){return root.val;}
		if(k <= leftLength){
			return getKthSmallestElement(root.left, k, map);
		}
		return getKthSmallestElement(root.right, k-leftLength-1, map);
		
	}

	private static int getSmallerNodesCount(TreeNode root, Map<TreeNode, Integer> map) {
		if(root == null){return 0;}
		int smaller = 1 + getSmallerNodesCount(root.left, map) + getSmallerNodesCount(root.right, map);
		map.put(root, smaller);
		return smaller;
	}

// Basic without followup
//	private static int getKthSmallestElement(TreeNode root, int k) {
//		if(root == null){return -1;}
//		Stack<TreeNode> stack = new Stack<>();
//		int count = 0;
//		TreeNode temp = root;
//		while(temp != null){
//			stack.push(temp);
//			temp = temp.left;
//		}
//		while(!stack.isEmpty()){
//			TreeNode node = stack.pop();
//			if(k == 1){
//				return node.val;
//			}
//			k--;
//			node = node.right;
//			while(node != null){
//				stack.push(node);
//				node = node.left;
//			}
//		}
//		return -1;
//	}

	


}
