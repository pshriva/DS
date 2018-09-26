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
}
