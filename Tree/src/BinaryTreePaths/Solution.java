package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;
//LCA
public class Solution {
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		List<String> list = getBinaryTreePaths(root);
		System.out.println(list);
	}

	private static List<String> getBinaryTreePaths(Node root) {
		List<String> paths = new ArrayList<>();
		getAllPaths(root, paths, "");
		return paths;
	}

	private static void getAllPaths(Node root, List<String> paths, String current) {
		if(root == null){return;}
		if(root.left == null && root.right == null){
			current = current + root.val;
			paths.add(current);
		}
		getAllPaths(root.left, paths, current + root.val + "->");
		getAllPaths(root.right, paths, current  + root.val + "->");
	}
	
	
	
//	https://leetcode.com/problems/binary-tree-paths/discuss/68278/My-Java-solution-in-DFS-BFS-recursion
//	BFS
//	public List<String> binaryTreePaths(TreeNode root) {
//	    List<String> list=new ArrayList<String>();
//	    Queue<TreeNode> qNode=new LinkedList<TreeNode>();
//	    Queue<String> qStr=new LinkedList<String>();
//	    
//	    if (root==null) return list;
//	    qNode.add(root);
//	    qStr.add("");
//	    while(!qNode.isEmpty()) {
//	        TreeNode curNode=qNode.remove();
//	        String curStr=qStr.remove();
//	        
//	        if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
//	        if (curNode.left!=null) {
//	            qNode.add(curNode.left);
//	            qStr.add(curStr+curNode.val+"->");
//	        }
//	        if (curNode.right!=null) {
//	            qNode.add(curNode.right);
//	            qStr.add(curStr+curNode.val+"->");
//	        }
//	    }
//	    return list;
//	}
	
	
	
	
//	https://leetcode.com/problems/binary-tree-paths/discuss/68278/My-Java-solution-in-DFS-BFS-recursion
//	DFS
	
//	public List<String> binaryTreePaths(TreeNode root) {
//	    List<String> list=new ArrayList<String>();
//	    Stack<TreeNode> sNode=new Stack<TreeNode>();
//	    Stack<String> sStr=new Stack<String>();
//	    
//	    if(root==null) return list;
//	    sNode.push(root);
//	    sStr.push("");
//	    while(!sNode.isEmpty()) {
//	        TreeNode curNode=sNode.pop();
//	        String curStr=sStr.pop();
//	        
//	        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
//	        if(curNode.left!=null) {
//	            sNode.push(curNode.left);
//	            sStr.push(curStr+curNode.val+"->");
//	        }
//	        if(curNode.right!=null) {
//	            sNode.push(curNode.right);
//	            sStr.push(curStr+curNode.val+"->");
//	        }
//	    }
//	    return list;
//	}
}
