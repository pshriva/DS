package BinaryTreeOrderTraversal2;
//LCA
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String []args){
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		List<List<Integer>> levelOrders = getLevelOrders(root);
		System.out.println(levelOrders);
	}

	private static List<List<Integer>> getLevelOrders(Node root) {
		if(root == null){return new ArrayList<List<Integer>>();}
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> curr = new ArrayList<>();
			for(int i = 0; i<size; i++){
				Node n = queue.poll();
				if(n.left != null){queue.add(n.left);}
				if(n.right != null){queue.add(n.right);}
				curr.add(n.val);
			}
			result.add(0,curr);
		}
		return result;
	}
}
