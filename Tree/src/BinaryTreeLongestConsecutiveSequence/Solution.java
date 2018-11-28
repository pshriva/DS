package BinaryTreeLongestConsecutiveSequence;
import java.util.*;
// LL

public class Solution {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(8);
		root.left.right.left.right = new TreeNode(9);
		
		int seq = getLongestConsecutiveSequence(root);
		System.out.println(seq);
	}

//	Iterative, nown
	private static int getLongestConsecutiveSequence(TreeNode root) {
		if(root==null)
			 return 0;
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
		nodeQueue.offer(root);
		sizeQueue.offer(1);
		int max=1;
		while(!nodeQueue.isEmpty()){
			TreeNode head = nodeQueue.poll();
			int size = sizeQueue.poll();
			if(head.left!=null){
				int leftSize=size;
				if(head.val==head.left.val-1){
					leftSize++;
					max = Math.max(max, leftSize);
				 }else{
					 leftSize=1;
				 }
				nodeQueue.offer(head.left);
				sizeQueue.offer(leftSize);
			}
			if(head.right != null){
				int rightSize = size;
				if(head.val==head.right.val-1){
					rightSize++;
					max = Math.max(max, rightSize);
				}
				else{
					rightSize = 1;
				}
				nodeQueue.offer(head.right);
				sizeQueue.offer(rightSize);
			}
		}
		return max;
	}

	
//	recursive, own
//	private static int getLongestConsecutiveSequence(TreeNode root) {
//		if(root == null){return 0;}
//		int[] max = new int[]{0};
//		getConsecutiveSequence(root, 1, max);
//		return max[0];
//	}
//	
//	private static void getConsecutiveSequence(TreeNode root, int count, int[] max) {
//		if(root.left == null && root.right == null){
//			max[0] = Math.max(max[0], count);
//			return;
//		}
//		int next = 1;
//		if(root.left != null){
//			if(root.left.val - root.val == 1){next = count+1;}
//			else{max[0] = Math.max(max[0], count);}
//			getConsecutiveSequence(root.left, next, max);
//		}
//		next = 1;
//		if(root.right != null){
//			if(root.right.val - root.val == 1){next = count+1;}
//			else{max[0] = Math.max(max[0], count);}
//			getConsecutiveSequence(root.right, next, max);
//		}
//	}

}
