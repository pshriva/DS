package VerticalOrderTraversal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		
//		BFS way, better
//		List<List<Integer>> verticalOrder = getVerticalOrderTraversedList(root);
//		System.out.println(verticalOrder);
		
//		Another way, recursive, and not very good
		root.getVerticalOrder(root);
		
	}

	private static List<List<Integer>> getVerticalOrderTraversedList(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){return result;}
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> distance = new LinkedList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		nodes.add(root);
		distance.add(0);
		while(!nodes.isEmpty()){
			TreeNode node = nodes.poll();
			int dis = distance.poll();
			if(!map.containsKey(dis)){map.put(dis, new ArrayList<>(Arrays.asList(node.val)));}
			else{map.get(dis).add(node.val);}
			if(node.left != null){
				nodes.add(node.left);
				distance.add(dis-1);
			}
			if(node.right != null){
				nodes.add(node.right);
				distance.add(dis+1);
			}
		}
		result.addAll(map.values());
		return result;
		
	}

}
