package RightSideView;

import java.util.*;
//LCA
public class Solution {
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		List<Integer> rightViewNodes = getRightViewNodes(root);
		System.out.println(rightViewNodes);
	}

	private static List<Integer> getRightViewNodes(Node root) {
		if(root == null){return null;}
		Queue<Node> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.add(root);
		int val = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			int i = 0;
			while(i++ < size){
				Node curr = queue.poll();
				if(curr.left != null){queue.add(curr.left);}
				if(curr.right != null){queue.add(curr.right);}
				val = curr.val;
			}
			result.add(val);
		}
		return result;
	}
}
