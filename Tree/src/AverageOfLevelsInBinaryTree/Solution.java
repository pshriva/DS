package AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String args[]){
		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		List<Double> avg = getAverage(root);
		System.out.println(avg);
	}

	private static List<Double> getAverage(Node root) {
		List<Double> result = new ArrayList<>();
		if(root == null){return result;}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			double sum = 0.0;
			for(int i = 0; i< size; i++){
				Node n = queue.poll();
				sum = sum + n.val;
				if(n.left != null){
					queue.add(n.left);
				}
				if(n.right != null){
					queue.add(n.right);
				}
			}
			result.add(sum/size);
		}
		return result;
	}
}
